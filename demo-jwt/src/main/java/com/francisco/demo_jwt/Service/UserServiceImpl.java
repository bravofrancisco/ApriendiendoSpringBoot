package com.francisco.demo_jwt.Service;

import com.francisco.demo_jwt.Models.User;
import com.francisco.demo_jwt.Repository.RepositoryRole;
import com.francisco.demo_jwt.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private RepositoryRole repositoryRole;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repositoryUser.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        return repositoryUser.save(user);
    }
}
