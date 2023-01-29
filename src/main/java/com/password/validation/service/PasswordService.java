package com.password.validation.service;

import com.password.validation.dto.PasswordRequestDTO;
import com.password.validation.entity.Password;
import com.password.validation.exception.PasswordBadRequestException;
import com.password.validation.repository.PasswordRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PasswordService {

    private final PasswordRepository passwordRepository;
    private final ValidationPasswordService validationPasswordService;

    public PasswordService(PasswordRepository passwordRepository, ValidationPasswordService validationPasswordService) {
        this.passwordRepository = passwordRepository;
        this.validationPasswordService = validationPasswordService;
    }

    public Password validatePassword(PasswordRequestDTO passwordRequestDTO) {
        log.info("Iniciando consulta UserService.validatePassword");

        if (passwordRequestDTO.getInput() == null) {
            throw new PasswordBadRequestException("Erro");
        }

        return passwordRepository.save(validationPasswordService.validate(passwordRequestDTO));

    }
}
