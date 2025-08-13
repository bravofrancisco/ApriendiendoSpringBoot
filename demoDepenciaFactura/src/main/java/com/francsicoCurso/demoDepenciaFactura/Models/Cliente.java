package com.francsicoCurso.demoDepenciaFactura.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@JsonIgnoreProperties({"targetSource","advisors"})
public class Cliente {

    @Value("${cliente.name}")
    private String name;

    @Value("${cliente.lastname}")
    private String lastname;

    public Cliente() {}

    public Cliente(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Cliente{name='" + name + "', lastname='" + lastname + "'}";
    }
}
