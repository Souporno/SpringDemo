package com.Prolabs.SpringDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NothingFoundException extends RuntimeException{

    public NothingFoundException() {
        super();
    }
    public NothingFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NothingFoundException(String message) {
        super(message);
    }
    public NothingFoundException(Throwable cause) {
        super(cause);
    }
}
