package com.estudandojava.services.resources;

import com.estudandojava.services.entities.User;
import com.estudandojava.services.services.UserService;
import com.estudandojava.services.services.exceptions.DataBaseException;
import com.estudandojava.services.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user){
        user=userService.insertUser(user);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
                buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deletUser(@PathVariable Long id){
        try {
            userService.deleteUser(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        User obj=userService.updateUser(id,user);
        return ResponseEntity.ok().body(obj);
    }

}
