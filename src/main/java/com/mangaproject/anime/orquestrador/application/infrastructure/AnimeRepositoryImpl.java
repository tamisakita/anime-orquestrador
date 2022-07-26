package com.mangaproject.anime.orquestrador.application.infrastructure;

import com.mangaproject.anime.orquestrador.domain.domain.Anime;
import com.mangaproject.anime.orquestrador.domain.port.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class AnimeRepositoryImpl implements AnimeRepository {
    private RestTemplate restTemplate;

    @Autowired
    public AnimeRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Anime> findAnime() {
        return restTemplate.getForEntity("http://localhost:8080/v1/anime-rest-api/", List.class).getBody();
    }

    @Override
    public Anime findAnimeById(Long id) {
        return null;
    }

    //return restTemplate.postForEntity(this.urlAtomBoleto + "inserirControleGeracaoBoletoOnline", entrada, ControleGeracaoBoletoOnline.class).getBody();
}
