package com.benz.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.benz.rest.entity.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable tx) {
		 ErrorMessage error =new ErrorMessage(tx.getMessage(),500,"www.benz.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}

}
