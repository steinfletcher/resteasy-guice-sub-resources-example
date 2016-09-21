package com.tapatron.reg.common;

import javax.inject.Singleton;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Singleton
public class ClientExceptionMapper implements ExceptionMapper<ClientErrorException> {

    @Override
    public Response toResponse(ClientErrorException e) {
        return Response.fromResponse(e.getResponse()).entity(e.getMessage()).build();
    }
}
