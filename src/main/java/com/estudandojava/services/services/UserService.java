package com.estudandojava.services.services;



import com.estudandojava.services.entities.User;
import com.estudandojava.services.repositories.UserRepository;
import com.estudandojava.services.services.exceptions.ResourceNotFoundException;
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
        return user.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insertUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);

    }

    public User updateUser(Long id, User user){
        User entity=userRepository.getReferenceById(id);
        updateUserData(entity,user);
        return userRepository.save(entity);

    }

    public void updateUserData(User entity,User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
