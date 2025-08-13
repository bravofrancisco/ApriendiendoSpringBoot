package com.francisco.demo_jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Embeddable
public class Audit {
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // --- Métodos de ciclo de vida corregidos ---

    @PrePersist
    public void prePersist() {
        System.out.println("EVENTO DEL CICLO DE VIDA DEL ENTITY PRE PERSIST");
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now(); // También inicializamos updatedAt
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Evento del ciclo de vida del objeto entity pre-update");
        this.updatedAt = LocalDateTime.now();
    }

    // --- Getters y setters para los nuevos campos ---
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // --- El resto de tus getters, setters y toString() ---
}
