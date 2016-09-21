package com.tapatron.reg.video;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Movie.Builder.class)
public class Movie {
    private final long id;
    private final String name;
    private final Genre genre;

    public Movie(long id, String name, Genre genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    @JsonPOJOBuilder
    public static class Builder {
        private long id;
        private String name;
        private Genre genre;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withGenre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Movie build() {
            return new Movie(id, name, genre);
        }
    }
}
