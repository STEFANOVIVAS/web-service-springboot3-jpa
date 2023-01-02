package com.estudandojava.services.services;



import com.estudandojava.services.entities.User;
import com.estudandojava.services.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();

    }
    public User findUserById(Long id){
        Optional<User> user=userRepository.findById(id);
        return user.get();
    }

    public User insertUser(User user){
        return userRepository.save(user);
    }
}
