package com.gabriel_vitors.spring_boot_curso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

    public UnsuportedMathOperationException(String message){
        super(message);
    }
}
