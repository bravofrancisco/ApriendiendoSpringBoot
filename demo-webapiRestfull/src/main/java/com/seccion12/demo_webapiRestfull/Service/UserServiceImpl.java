package com.seccion12.demo_webapiRestfull.Service;

import com.seccion12.demo_webapiRestfull.Models.User;
import com.seccion12.demo_webapiRestfull.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
