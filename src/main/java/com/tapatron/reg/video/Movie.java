package com.tapatron.reg.video;

import com.fasterxml.jackson.annotation.JsonProperty;

import dk.nykredit.jackson.dataformat.hal.HALLink;
import dk.nykredit.jackson.dataformat.hal.annotation.Link;
import dk.nykredit.jackson.dataformat.hal.annotation.Resource;

@Resource
public class Movie {

  private final long id;
  private final String name;

  @Link
  private HALLink genre;

  public Movie(
      @JsonProperty(value = "id") long id,
      @JsonProperty(value = "name") String name,
      @JsonProperty(value = "genre") HALLink genre) {
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

  public HALLink getGenre() {
    return genre;
  }
}
