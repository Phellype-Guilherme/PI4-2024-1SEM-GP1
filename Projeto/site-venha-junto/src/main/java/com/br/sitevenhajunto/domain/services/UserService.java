package com.br.sitevenhajunto.domain.services;

import com.br.sitevenhajunto.domain.UserRepository;
import com.br.sitevenhajunto.domain.entitie.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
