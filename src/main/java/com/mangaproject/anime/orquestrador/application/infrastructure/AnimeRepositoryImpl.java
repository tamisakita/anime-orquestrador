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

@Repository
@Slf4j
public class AnimeRepositoryImpl implements AnimeRepository {
    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;

    private static final String ANIME_EXCHANGE = "animes";

    private static final String BASE_PATH = "http://localhost:8080/v1/anime-rest-api/";

    @Autowired
    public AnimeRepositoryImpl(RestTemplate restTemplate, RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<Anime> findAnime() {
        var animeList = List.of(restTemplate.getForEntity(BASE_PATH, Anime[].class).getBody());
        rabbitTemplate.convertAndSend(ANIME_EXCHANGE, "anime-list-key", JsonUtil.toJson(animeList));
        return animeList;
    }

    @Override
    public Anime findAnimeById(Long id) {
        return restTemplate.getForEntity(BASE_PATH + "{id}", Anime.class, id).getBody();
    }

    @Override
    public Anime saveAnime(Anime anime) {
        var animeObj = restTemplate.postForEntity(BASE_PATH + "save", anime, Anime.class).getBody();
        rabbitTemplate.convertAndSend(ANIME_EXCHANGE, "anime-routing-key", JsonUtil.toJson(animeObj));
        return animeObj;
    }

    @Override
    public Anime updateAnime(Anime anime) {
        restTemplate.put(BASE_PATH + "{id}", anime, anime.getId());
        return anime;
    }

    @Override
    public void deleteAnime(Long id) {
        restTemplate.delete(BASE_PATH + "{id}", id);
    }

}
