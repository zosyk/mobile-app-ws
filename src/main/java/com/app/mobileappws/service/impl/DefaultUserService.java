package com.app.mobileappws.service.impl;

import com.app.mobileappws.model.response.UpdateUser;
import com.app.mobileappws.model.response.User;
import com.app.mobileappws.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class DefaultUserService implements UserService {

    private static Map<String, User> users = new HashMap<>();


    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());

        users.put(user.getId(), user);

        return user;
    }

    @Override
    public User updateUser(String id, UpdateUser updateUser) {
        if (getUser(id) == null) {
            return null;
        }

        User user = users.get(id);
        user.setFirstname(updateUser.getFirstname());
        user.setLastname(updateUser.getLastname());

        return user;
    }

    @Override
    public User removeUser(String id) {
        return users.remove(id);
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }
}
