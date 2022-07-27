package com.mangaproject.anime.orquestrador.domain.port;

import com.mangaproject.anime.orquestrador.domain.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    List<Anime> findAnime();

    Anime findAnimeById(Long id);

    Anime saveAnime(Anime anime);

    Anime updateAnime(Anime anime);

    void deleteAnime(Long id);
}
