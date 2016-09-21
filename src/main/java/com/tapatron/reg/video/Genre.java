package com.tapatron.reg.video;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Genre.Builder.class)
public class Genre {
  private final String name;

  public Genre(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private String name;

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Genre build() {
      return new Genre(name);
    }
  }
}
