package com.password.validation.util;

import com.password.validation.dto.PasswordRequestDTO;
import com.password.validation.entity.Password;

public class PasswordMock {

    public static Password generatePasswordValid() {
        return new Password("AbTp9!fok", true);
    }

    public static Password generatePasswordInvalid() {
        return new Password("AbTp9 fok", false);
    }

    public static PasswordRequestDTO generateValidPasswordRequestDTO() {
        return new PasswordRequestDTO("AbTp9!fok");
    }

    public static PasswordRequestDTO generateInvalidPasswordRequestDTO() {
        return new PasswordRequestDTO("AbTp9 fok");
    }
}