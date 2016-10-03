package com.tapatron.reg;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import dk.nykredit.jackson.dataformat.hal.HALMapper;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonHALConfig implements ContextResolver<ObjectMapper> {

  private final ObjectMapper objectMapper;

  public JacksonHALConfig() {
    objectMapper = new HALMapper();

  }

  @Override
  public ObjectMapper getContext(Class<?> objectType) {
    return objectMapper;
  }
}