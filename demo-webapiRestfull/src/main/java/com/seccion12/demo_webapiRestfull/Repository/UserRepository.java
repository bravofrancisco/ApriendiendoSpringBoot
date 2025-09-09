package com.seccion12.demo_webapiRestfull.Repository;

import com.seccion12.demo_webapiRestfull.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
