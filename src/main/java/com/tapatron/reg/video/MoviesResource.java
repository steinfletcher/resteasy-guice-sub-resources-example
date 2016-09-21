package com.tapatron.reg.video;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface MoviesResource {
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  Movie movie(@PathParam("id") long id);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  Movie create(CreateMovie movie);
}
