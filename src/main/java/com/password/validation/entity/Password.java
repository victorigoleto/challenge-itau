package com.password.validation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "password")
public class Password {

    @Id
    private UUID id;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String input;

    @Column(name = "PASSWORD_STATUS", nullable = false, length = 6)
    private Boolean output;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID();
    }

    public Password(String input, Boolean output) {
        this.input = input;
        this.output = output;
    }
}
