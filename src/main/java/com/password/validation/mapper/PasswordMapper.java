package com.password.validation.mapper;

import com.password.validation.dto.PasswordResponseDTO;
import com.password.validation.entity.Password;
import org.springframework.stereotype.Component;

@Component
public class PasswordMapper {

    public static PasswordResponseDTO isValid(Password password) {
        PasswordResponseDTO passwordResponseDTO = new PasswordResponseDTO();
        passwordResponseDTO.setOutput(password.getOutput());
        return passwordResponseDTO;
    }
}
