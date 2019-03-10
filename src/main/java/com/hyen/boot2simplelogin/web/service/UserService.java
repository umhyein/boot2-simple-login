package com.hyen.boot2simplelogin.web.service;

import com.hyen.boot2simplelogin.web.domain.User;
import com.hyen.boot2simplelogin.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByid(String id){
        return userRepository.findById(id);
    }

}
