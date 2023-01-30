package com.password.validation.controller;

import com.password.validation.dto.PasswordRequestDTO;
import com.password.validation.dto.PasswordResponseDTO;
import com.password.validation.mapper.PasswordMapper;
import com.password.validation.service.PasswordService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/password")
public class PasswordController {

    private final PasswordService passwordService;
    private final PasswordMapper passwordMapper;

    public PasswordController(PasswordService passwordService, PasswordMapper passwordMapper) {
        this.passwordService = passwordService;
        this.passwordMapper = passwordMapper;
    }

    @PostMapping(path = "/validation")
    public PasswordResponseDTO validatePassword(@RequestBody @Valid PasswordRequestDTO passwordRequestDTO) {

        boolean isPasswordValid = passwordService.validatePassword(passwordRequestDTO);

        return passwordMapper.toDto(isPasswordValid);

    }
}
