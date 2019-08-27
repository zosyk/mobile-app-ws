package com.app.mobileappws.model.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class User {
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    @Email
    private String email;
    private String id;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
