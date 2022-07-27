package com.mangaproject.anime.orquestrador.application.presentation;

import com.mangaproject.anime.orquestrador.application.mapper.AnimeMapper;
import com.mangaproject.anime.orquestrador.application.presentation.representation.AnimeRequestRepresentation;
import com.mangaproject.anime.orquestrador.application.presentation.representation.AnimeResponseRepresentation;
import com.mangaproject.anime.orquestrador.domain.service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@AllArgsConstructor
@RestController
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping(path = "/")
    public ResponseEntity<List<AnimeResponseRepresentation>> searchAnime() {
        var animeList = animeService.findAnime();
        var representationList = AnimeMapper.toAnimeResponseRepresentationList(animeList);
//        return ResponseEntity.ok(representationList);
        return ResponseEntity.status(HttpStatus.OK).body(representationList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AnimeResponseRepresentation> searchAnimeById(@PathVariable(value = "id") Long id) {
        var animeById = animeService.findAnimeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(AnimeMapper.toRepresentation(animeById));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<AnimeResponseRepresentation> save(@RequestBody AnimeRequestRepresentation body) {
        var anime = animeService.saveAnime(AnimeMapper.toDomain(body));
        if (nonNull(anime)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.toRepresentation(anime));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AnimeResponseRepresentation> updateAnime(
            @PathVariable(value = "id") Long id,
            @RequestBody AnimeRequestRepresentation body) {

        var animeUpdated = animeService.updateAnime(id, AnimeMapper.toDomain(body));

        return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.toRepresentation(animeUpdated));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnime(@PathVariable(value = "id") Long id) {
        animeService.deleteAnime(id);
        return ResponseEntity.ok().build();
    }
}
