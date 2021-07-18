package com.Prolabs.SpringDemo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestException extends RuntimeException{
    public RequestException() {
        super();
    }
    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public RequestException(String message) {
        super(message);
    }
    public RequestException(Throwable cause) {
        super(cause);
    }
}
