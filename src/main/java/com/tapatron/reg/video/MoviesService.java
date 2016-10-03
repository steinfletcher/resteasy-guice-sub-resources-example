package com.tapatron.reg.video;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import java.net.URI;

import dk.nykredit.jackson.dataformat.hal.HALLink;

public class MoviesService implements MoviesResource {

  private final HALLink genreLink;

  @Inject
  public MoviesService(@Assisted String genre) {
    this.genreLink = new HALLink.Builder(URI.create("/genre/" + genre)).build();
  }

  @Override
  public Movie movie(long id) {
    return new Movie(id, "Jaws", genreLink);
  }

  @Override
  public Movie create(CreateMovie movie) {
    return new Movie(51, movie.getTitle(), genreLink);
  }

}
