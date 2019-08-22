package com.app.mobileappws.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam("limit") int limit) {
        return "get users was called with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable int userId) {
        return "return getUser was called with userId: " + userId;
    }

    @PostMapping
    public String createUser() {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }


    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }

}
