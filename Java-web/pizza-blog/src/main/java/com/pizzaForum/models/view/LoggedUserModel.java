package com.pizzaForum.models.view;

public class LoggedUserModel {

    private String username;

    private boolean isAdmin;

    public LoggedUserModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
