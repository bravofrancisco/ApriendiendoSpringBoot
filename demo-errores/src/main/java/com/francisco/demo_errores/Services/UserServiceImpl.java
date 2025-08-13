package com.francisco.demo_errores.Services;

import com.francisco.demo_errores.Models.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    private final List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
        users.add(new User("pepe", "pepe", 1L));
        users.add(new User("pepe2", "pepe2", 2L));
        users.add(new User("pepe3", "pepe3", 3L));
        users.add(new User("pepe4", "pepe4", 4L));
        users.add(new User("pepe5", "pepe5", 5L));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }
}
