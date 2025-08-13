package com.francisco.demo_errores.Services;

import com.francisco.demo_errores.Models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    List<User> findAll();               // Corregido: antes era Optional<User>
    Optional<User> findById(Long id);
}
