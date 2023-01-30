package com.password.validation.service;

import com.password.validation.dto.PasswordRequestDTO;
import com.password.validation.entity.Password;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PasswordValidator {

    String REGEX_VALIDATOR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+])(?:([0-9a-zA-Z!@#$%^&*()-+])(?!\\1)){9,}$";

    public Password validate(PasswordRequestDTO passwordRequestDTO) {
        Password password = new Password();

        validateCharacterDuplicate(passwordRequestDTO);

        password.setPassword(passwordRequestDTO.getInput());

        if (passwordRequestDTO.getInput().matches(REGEX_VALIDATOR)) {
            password.setIsValid(true);
            return password;
        } else {
            password.setIsValid(false);
            return password;
        }
    }

    private void validateCharacterDuplicate(PasswordRequestDTO passwordRequestDTO) {
        passwordRequestDTO.getInput().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> {
                    if (value > 1) {
                        passwordRequestDTO.setInput(" ");
                    }
                });
    }
}
