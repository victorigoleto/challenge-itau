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

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "status", nullable = false, length = 6)
    private Boolean isValid;

    public Password(String password, Boolean isValid) {
        this.password = password;
        this.isValid = isValid;
    }

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID();
    }
}
