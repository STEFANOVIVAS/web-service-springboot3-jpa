package com.estudandojava.services.resources;

import com.estudandojava.services.entities.User;
import com.estudandojava.services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    public UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> list= userService.findAllUsers();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        User user=userService.findUserById(id);
        return ResponseEntity.ok().body(user);

    }
}
