package com.example.accountsystem.services;

import com.example.accountsystem.models.User;
import com.example.accountsystem.repositories.UserRepository;
import com.example.accountsystem.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        User found = userRepository.findByUsername(user.getUsername());

        if(found == null) {
            this.userRepository.save(user);
        }
    }
}
