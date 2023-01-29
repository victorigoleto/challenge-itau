package com.password.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PasswordBadRequestException extends RuntimeException{

    public PasswordBadRequestException(String erro) {
        super(String.format("Um ou mais requisitos da senha não foram preenchidos, tente novamente.", erro));
    }
}
