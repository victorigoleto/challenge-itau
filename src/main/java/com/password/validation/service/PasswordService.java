package com.password.validation.service;

import com.password.validation.dto.PasswordRequestDTO;
import com.password.validation.entity.Password;
import com.password.validation.repository.PasswordRepository;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final PasswordRepository passwordRepository;
    private final ValidationPasswordService validationPasswordService;

    public PasswordService(PasswordRepository passwordRepository, ValidationPasswordService validationPasswordService) {
        this.passwordRepository = passwordRepository;
        this.validationPasswordService = validationPasswordService;
    }

    public Password validatePassword(PasswordRequestDTO passwordRequestDTO) {
        return passwordRepository.save(validationPasswordService.validate(passwordRequestDTO));
    }
}