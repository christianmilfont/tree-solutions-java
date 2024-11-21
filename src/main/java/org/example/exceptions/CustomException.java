package org.example.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class CustomException extends WebApplicationException {

    public CustomException(String message, int statusCode) {
        super(Response.status(statusCode).entity(message).build());
    }
}
