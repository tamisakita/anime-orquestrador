package com.mangaproject.anime.orquestrador.domain.domain;

import com.mangaproject.anime.orquestrador.domain.enums.genreType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Anime {

    private Long id;
    private String name;
    private String author;
    private Integer yearPublication;
    private Integer episodesNumber;
    private genreType genre;
    private String synopsis;

}

