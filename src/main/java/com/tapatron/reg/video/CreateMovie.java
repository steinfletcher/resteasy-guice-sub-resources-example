package com.tapatron.reg.video;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateMovie.Builder.class)
public class CreateMovie {
  private final String title;

  public CreateMovie(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  @JsonPOJOBuilder
  public static class Builder {

    private String title;

    public Builder withTitle(String title) {
      this.title = title;
      return this;
    }

    public CreateMovie build() {
      return new CreateMovie(title);
    }
  }
}
