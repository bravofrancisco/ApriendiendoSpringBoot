package com.francisco.demo_jwt.Repository;

import com.francisco.demo_jwt.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User, Long> {
}
