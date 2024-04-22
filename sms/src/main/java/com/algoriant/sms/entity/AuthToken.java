package com.algoriant.sms.entity;

public class AuthToken {

    private String token;
    private String username;
    private String password;

    public AuthToken(){

    }

    public AuthToken(String token, String username, String password){
        this.token = token;
        this.username = username;
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
