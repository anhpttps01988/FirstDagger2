package com.example.anhptt.architechmvp.login.pojo;

import java.io.Serializable;

import javax.inject.Inject;

public class User implements Serializable {

    private String User;
    private String Pass;

    @Inject
    public User(){

    }

    public User(String User, String Pass) {
        this.User = User;
        this.Pass = Pass;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
}
