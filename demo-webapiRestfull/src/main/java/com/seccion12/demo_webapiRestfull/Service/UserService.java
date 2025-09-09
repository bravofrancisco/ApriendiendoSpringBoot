package com.seccion12.demo_webapiRestfull.Service;

import com.seccion12.demo_webapiRestfull.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User>findById(Long id);
    User save (User user);
}
