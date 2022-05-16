package com.masudbappy.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDaoService userDaoService;

    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    //saveUser
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User saveUser = userDaoService.save(user);
        //Created
        ///user/{id}
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
        //findOne
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
            if (user == null){
                throw new UserNotFoundException("id-"+id);
            }
        return user;
    }
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) {
        User user = userDaoService.delete(id);
        if (user == null){
            throw new UserNotFoundException("id-"+id);
        }
    }
}
