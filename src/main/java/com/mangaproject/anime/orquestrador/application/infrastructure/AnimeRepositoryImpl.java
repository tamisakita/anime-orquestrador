package com.mangaproject.anime.orquestrador.application.infrastructure;

import com.fasterxml.jackson.databind.type.ReferenceType;
import com.mangaproject.anime.orquestrador.domain.domain.Anime;
import com.mangaproject.anime.orquestrador.domain.port.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimeRepositoryImpl implements AnimeRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public AnimeRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Anime> findAnime() {
        //return restTemplate.exchange("http://localhost:8080/v1/anime-rest-api/", HttpMethod.GET, null, List.class).getBody();
        return List.of(restTemplate.getForEntity("http://localhost:8080/v1/anime-rest-api/", Anime[].class).getBody());
    }

    @Override
    public Anime findAnimeById(Long id) {
        return restTemplate.getForEntity("http://localhost:8080/v1/anime-rest-api/{id}", Anime.class, id).getBody();
    }

    @Override
    public Anime saveAnime(Anime anime) {
        return restTemplate.postForEntity("http://localhost:8080/v1/anime-rest-api/save", anime, Anime.class).getBody();
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
