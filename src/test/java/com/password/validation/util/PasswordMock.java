package com.password.validation.util;

import com.password.validation.entity.Password;

public class PasswordMock {

    public static Password toPasswordValid() {
        Password password = new Password();

        password.setInput("AbTp9!fok");
        password.setOutput(true);

        return password;
    }

    public static Password toPasswordInvalid() {
        Password password = new Password();

        password.setInput("AbTp9 fok");
        password.setOutput(false);

        return password;
    }
}