package com.orquestrador.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class MensagemErrorCamelException extends RuntimeException {

    public MensagemErrorCamelException(String message) {
        super(message);
    }
}
