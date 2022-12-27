package com.estudandojava.services.resources;

import com.estudandojava.services.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAllUsers(){
        User u= new User(12345L,"Stefano","stefano@gmail.com","1234-8765","123456");
        return ResponseEntity.ok().body(u);

    }
}
