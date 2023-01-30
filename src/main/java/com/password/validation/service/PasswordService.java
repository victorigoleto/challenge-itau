package com.password.validation.service;

import com.password.validation.dto.PasswordRequestDTO;
import com.password.validation.entity.Password;
import com.password.validation.repository.PasswordRepository;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final PasswordRepository passwordRepository;
    private final PasswordValidator validationPasswordService;

    public PasswordService(PasswordRepository passwordRepository, PasswordValidator validationPasswordService) {
        this.passwordRepository = passwordRepository;
        this.validationPasswordService = validationPasswordService;
    }

    public boolean validatePassword(PasswordRequestDTO passwordRequestDTO) {
        Password passwordValidated = validationPasswordService.validate(passwordRequestDTO);

        if (passwordValidated.getIsValid()) {
            passwordRepository.save(passwordValidated);
            return true;
        }

        return false;
    }
}