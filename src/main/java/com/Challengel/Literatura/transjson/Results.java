package com.Challengel.Literatura.transjson;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results (
        @JsonAlias("id") long idLibro,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<authors> authors,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") long numeroDescargas
) {}
