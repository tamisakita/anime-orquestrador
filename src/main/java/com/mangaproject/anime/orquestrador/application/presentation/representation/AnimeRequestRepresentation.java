package com.mangaproject.anime.orquestrador.application.presentation.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mangaproject.anime.orquestrador.application.presentation.representation.enums.genreTypeRepresentation;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimeRequestRepresentation {

    @JsonProperty("name")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("yerPublication")
    private Integer yearPublication;

    @JsonProperty("episodesNumber")
    private Integer episodesNumber;

    @JsonProperty("genre")
    private genreTypeRepresentation genre;

    @JsonProperty("synopsis")
    private String synopsis;

}
