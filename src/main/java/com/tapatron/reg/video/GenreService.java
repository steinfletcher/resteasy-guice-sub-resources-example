package com.tapatron.reg.video;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GenreService implements GenreResource {

  private final MoviesResourceFactory moviesResourceFactory;

  @Inject
  public GenreService(MoviesResourceFactory moviesResourceFactory) {
    this.moviesResourceFactory = moviesResourceFactory;
  }

  @Override
  public Genre genre(String name) {
    return new Genre.Builder()
        .withName(name)
        .build();
  }

  @Override
  public MoviesResource moviesResource(String genre) {
    return moviesResourceFactory.create(genre);
  }
}
