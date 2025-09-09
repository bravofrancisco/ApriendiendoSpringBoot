package com.francisco.demo_jwt.Service;


import com.francisco.demo_jwt.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User save (User user);
}
