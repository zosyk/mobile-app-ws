package com.app.mobileappws.controller;

import com.app.mobileappws.model.response.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Map<String, User> users = new HashMap<>();

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get users was called with page = " + page + " and limit = " + limit + " , and sort: " + sort;
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUser(@PathVariable String id) {

        if(!users.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        user.setId(UUID.randomUUID().toString());

        users.put(user.getId(), user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        if(!users.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        users.remove(id);

        return ResponseEntity.noContent().build();
    }

}
