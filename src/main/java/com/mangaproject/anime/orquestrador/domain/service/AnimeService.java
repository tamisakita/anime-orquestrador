package com.mangaproject.anime.orquestrador.domain.service;

import com.mangaproject.anime.orquestrador.domain.camel.CamelContextWrapper;
import com.mangaproject.anime.orquestrador.domain.camel.route.AnimeRouter;
import com.mangaproject.anime.orquestrador.domain.domain.Anime;
import org.apache.camel.ProducerTemplate;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Servic do domínio
public class AnimeService {
    private final ProducerTemplate template;

    public AnimeService(CamelContextWrapper wrapper) {
        this.template = wrapper.createProducerTemplate();
    }
    public List<Anime> findAnime() {
        //List<Anime> animeList = new ArrayList<>();
        //var findAnimeReturn = (List<Anime>) template.requestBody(AnimeRouter.ROUTE_URI, null, Object.class);
        //animeList.addAll(findAnimeReturn);
        return template.requestBody(AnimeRouter.ROUTE_URI, null, List.class);
    }

    public Anime findAnimeById(Long id) {
        return template.requestBody(AnimeRouter.ROUTE_URI_BY_ID, id, Anime.class);
    }

    public Anime saveAnime(Anime anime) {
        return template.requestBody(AnimeRouter.ROUTE_URI_SAVE, anime, Anime.class);
    }

    public Anime updateAnime(Long id, Anime anime) {
        anime.setId(id);
        return template.requestBody(AnimeRouter.ROUTE_URI_UPDATE, anime, Anime.class);
    }

    public void deleteAnime(Long id) {
        template.sendBody(AnimeRouter.ROUTE_URI_DELETE, id);
    }
}
