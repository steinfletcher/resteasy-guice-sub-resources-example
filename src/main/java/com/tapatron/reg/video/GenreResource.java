package com.tapatron.reg.video;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("genre")
public interface GenreResource {
  @GET
  @Path("{name}")
  @Produces(MediaType.APPLICATION_JSON)
  Genre genre(@PathParam("name") String name);

  @Path("{name}/movies")
  MoviesResource moviesResource(@PathParam("name") String genre);
}
