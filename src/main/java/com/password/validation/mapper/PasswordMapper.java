package com.password.validation.mapper;

import com.password.validation.dto.PasswordResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PasswordMapper {

    public PasswordResponseDTO toDto(boolean isValid) {
        return new PasswordResponseDTO(isValid);
    }
}
