package com.Challengel.Literatura.transjson;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonIgnoreProperties(ignoreUnknown = true)
public record authors (
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int fechaNacimiento,
        @JsonAlias("death_year") int fechaDefuncion
) {
}
