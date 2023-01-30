package com.password.validation.util;

import com.password.validation.dto.PasswordRequestDTO;

public class PasswordRequestMock {

    public static PasswordRequestDTO toPasswordRequestDTO() {
        PasswordRequestDTO passwordRequestDTO = new PasswordRequestDTO();
        passwordRequestDTO.setInput("AbTp9!fok");
        return passwordRequestDTO;
    }
}
