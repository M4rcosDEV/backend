package com.baozistore.api.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente extends AbstractEntity<Long>{

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate clienteDesde;

    @PrePersist
    public void prePersist() {
        if (this.clienteDesde == null) {
            this.clienteDesde = LocalDate.now();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getClienteDesde() {
        return clienteDesde;
    }

    public void setClienteDesde(LocalDate clienteDesde) {
        this.clienteDesde = clienteDesde;
    }
}
