package com.password.validation.controller;

import com.password.validation.dto.PasswordRequestDTO;
import com.password.validation.entity.Password;
import com.password.validation.mapper.PasswordMapper;
import com.password.validation.service.PasswordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping(path = "/validation")
    public ResponseEntity<?> validatePassword(@RequestBody @Valid PasswordRequestDTO passwordRequestDTO) {

        Password password = passwordService.validatePassword(passwordRequestDTO);

        if (password.getInput() != null) {
            return ResponseEntity.ok(PasswordMapper.isValid(password));
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
