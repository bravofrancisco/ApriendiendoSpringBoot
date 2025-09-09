package com.francisco.demo_jwt.Repository;

import com.francisco.demo_jwt.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryRole extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
