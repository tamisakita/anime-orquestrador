package com.mangaproject.anime.orquestrador.application.infrastructure;

import com.mangaproject.anime.orquestrador.domain.domain.Anime;
import com.mangaproject.anime.orquestrador.domain.port.AnimeRepository;
import com.mangaproject.anime.orquestrador.domain.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Queue;

@Repository
@Slf4j
public class AnimeRepositoryImpl implements AnimeRepository {
    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AnimeRepositoryImpl(RestTemplate restTemplate, RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<Anime> findAnime() {
        var animeList = List.of(restTemplate.getForEntity("http://localhost:8080/v1/anime-rest-api/", Anime[].class).getBody());
        rabbitTemplate.convertAndSend("animes", "anime-list-key", JsonUtil.toJson(animeList));
        return animeList;
    }

    @Override
    public Anime findAnimeById(Long id) {
        return restTemplate.getForEntity("http://localhost:8080/v1/anime-rest-api/{id}", Anime.class, id).getBody();
    }

    @Override
    public Anime saveAnime(Anime anime) {
        var animeObj = restTemplate.postForEntity("http://localhost:8080/v1/anime-rest-api/save", anime, Anime.class).getBody();
        rabbitTemplate.convertAndSend("animes", "anime-routing-key", JsonUtil.toJson(animeObj));
        return animeObj;
    }

    @Override
    public Anime updateAnime(Anime anime) {
        restTemplate.put("http://localhost:8080/v1/anime-rest-api/{id}", anime, anime.getId());
        return anime;
    }

    @Override
    public void deleteAnime(Long id) {
        restTemplate.delete("http://localhost:8080/v1/anime-rest-api/{id}", id);
    }

}
