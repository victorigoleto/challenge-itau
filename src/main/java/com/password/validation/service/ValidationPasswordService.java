package com.password.validation.service;

import com.password.validation.dto.PasswordRequestDTO;
import com.password.validation.entity.Password;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ValidationPasswordService {

    String REGEX_VALIDATOR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+])(?:([0-9a-zA-Z!@#$%^&*()-+])(?!\\1)){9,}$";

    public Password validate(PasswordRequestDTO passwordRequestDTO) {
        log.info("Iniciando consulta ValidatorPasswordService.validate");

        Password password = new Password();

        validateCharacterDuplicate(passwordRequestDTO);

        if (passwordRequestDTO.getInput().matches(REGEX_VALIDATOR)) {
            password.setInput(passwordRequestDTO.getInput());
            password.setOutput(true);
            return password;
        } else {
            password.setInput(passwordRequestDTO.getInput());
            password.setOutput(false);
            return password;
        }
    }

    private void validateCharacterDuplicate(PasswordRequestDTO request) {
        log.info("Iniciando consulta ValidatorService.validatePasswordCharDuplicate");

        request.getInput().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> {
                    if (value > 1) {
                        request.setInput(" ");
                    }
                });
    }
}
