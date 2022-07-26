package com.mangaproject.anime.orquestrador.domain.camel.route;

import com.mangaproject.anime.orquestrador.domain.port.AnimeRepository;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
public class AnimeRouter extends RouteBuilder {
    public static final String ROUTE_URI = "direct:animeRouter";
    public static final String ROUTE_URI_BY_ID = "direct:AnimeRouterById";

    AnimeRepository animeRepository;

    @Override
    public void configure() {
        from(ROUTE_URI)
                .bean(animeRepository, "findAnime");
        from(ROUTE_URI_BY_ID)
                .bean(animeRepository, "findAnimeById");
    }
}
