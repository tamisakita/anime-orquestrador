package com.mangaproject.anime.orquestrador.domain.service;

import com.mangaproject.anime.orquestrador.domain.camel.CamelContextWrapper;
import com.mangaproject.anime.orquestrador.domain.camel.route.AnimeRouter;
import com.mangaproject.anime.orquestrador.domain.domain.Anime;
import org.apache.camel.ProducerTemplate;

import java.util.List;

//Servic do domínio
public class AnimeService {
    private final ProducerTemplate template;

    public AnimeService(CamelContextWrapper wrapper) {
        this.template = wrapper.createProducerTemplate();
    }
    public List<Anime> findAnime() {
        return template.requestBody(AnimeRouter.ROUTE_URI, null, List.class);
    }

    public Anime findAnimeById(Long id) {
        return template.requestBody(AnimeRouter.ROUTE_URI_BY_ID, id, Anime.class);
    }
}
