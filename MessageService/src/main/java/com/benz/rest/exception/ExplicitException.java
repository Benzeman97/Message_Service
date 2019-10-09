package com.benz.rest.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.benz.rest.entity.ErrorMessage;
import com.benz.rest.entity.Message;

public class ExplicitException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	public ExplicitException(String msg)
	{
		ErrorMessage error = new ErrorMessage(msg,404,"www.benz.com");
        Response res = Response.status(Status.NOT_FOUND).entity(error).build();
        throw new NotFoundException(res);
	}

}
