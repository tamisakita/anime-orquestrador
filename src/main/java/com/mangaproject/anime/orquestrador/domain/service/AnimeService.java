package com.mangaproject.anime.orquestrador.domain.service;

import org.apache.camel.ProducerTemplate;

//Servic do domínio
public class AnimeService {
    private final ProducerTemplate template;

    public AnimeService(ProducerTemplate template) {
        this.template = template;
    }
}
