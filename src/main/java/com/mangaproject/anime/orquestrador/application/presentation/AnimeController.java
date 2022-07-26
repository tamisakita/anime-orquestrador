package com.mangaproject.anime.orquestrador.application.presentation;

import com.mangaproject.anime.orquestrador.application.mapper.AnimeMapper;
import com.mangaproject.anime.orquestrador.application.presentation.representation.AnimeResponseRepresentation;
import com.mangaproject.anime.orquestrador.domain.service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping(path = "/")
    public ResponseEntity<List<AnimeResponseRepresentation>> searchAnime() {
        var animeList = animeService.findAnime();
        var representationList = AnimeMapper.toAnimeResponseRepresentationList(animeList);
        return ResponseEntity.ok(representationList);
    }
}
