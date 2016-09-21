package com.tapatron.reg.video;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class MoviesService implements MoviesResource {
  private final String genre;

  @Inject
  public MoviesService(@Assisted String genre) {
    this.genre = genre;
  }

  @Override
  public Movie movie(long id) {
    return new Movie.Builder()
        .withId(id)
        .withName("Jaws")
        .withGenre(new Genre(genre))
        .build();
  }

  @Override
  public Movie create(CreateMovie movie) {
    return new Movie.Builder()
        .withId(51)
        .withName(movie.getTitle())
        .withGenre(new Genre(genre))
        .build();
  }
}
