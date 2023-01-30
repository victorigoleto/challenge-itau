package com.password.validation;

import com.password.validation.entity.Password;
import com.password.validation.service.PasswordService;
import com.password.validation.util.PasswordMock;
import com.password.validation.util.PasswordRequestMock;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/*
@SpringBootTest
class PasswordServiceTest {

    @InjectMocks
    PasswordService passwordService;

    @Test
    void retornaSucessoComOutputTrue() {
        when(passwordService.validatePassword(PasswordRequestMock.toPasswordRequestDTO())).thenReturn(any(Password.class));

        Password password = PasswordMock.toPasswordValid();

        assertEquals("AbTp9!fok", password.getInput());
        assertTrue(password.getOutput());
    }

    @Test
    void retornaSucessoComOutputFalse() {
        when(passwordService.validatePassword(PasswordRequestMock.toPasswordRequestDTO())).thenReturn(PasswordMock.toPasswordInvalid());

        Boolean retorno = PasswordMock.toPasswordInvalid().getOutput();

        assertFalse(retorno.booleanValue());
    }

}
*/