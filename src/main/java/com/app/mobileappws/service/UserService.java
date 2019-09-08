package com.app.mobileappws.service;

import com.app.mobileappws.model.response.UpdateUser;
import com.app.mobileappws.model.response.User;

public interface UserService {

    User createUser(User userDetails);
    User updateUser(String id, UpdateUser userDetails);
    User removeUser(String id);
    User getUser(String id);
}
