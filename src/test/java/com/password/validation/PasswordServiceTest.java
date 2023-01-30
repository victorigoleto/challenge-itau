package com.password.validation;

import com.password.validation.repository.PasswordRepository;
import com.password.validation.service.PasswordService;
import com.password.validation.service.PasswordValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.password.validation.util.PasswordMock.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class PasswordServiceTest {

    @Mock
    PasswordRepository passwordRepository;

    @Mock
    PasswordValidator passwordValidator;

    @InjectMocks
    PasswordService passwordService;

    @Test
    void retornaSucessoComStatusTrue() {
        when(passwordValidator.validate(any())).thenReturn(generatePasswordValid());

        boolean response = passwordService.validatePassword(generateValidPasswordRequestDTO());

        assertTrue(response);
    }

    @Test
    void retornaSucessoComStatusFalse() {
        when(passwordValidator.validate(any())).thenReturn(generatePasswordInvalid());

        boolean response = passwordService.validatePassword(generateInvalidPasswordRequestDTO());

        assertFalse(response);
    }

}