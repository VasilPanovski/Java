package com.pizzaForum.models.binding;


import com.pizzaForum.utils.constants.Constants;

import javax.validation.constraints.Pattern;

public class RegisterModel {

    @Pattern(regexp = "^[a-z0-9]{3,}$", message = Constants.INVALID_USERNAME)
    private String username;

    @Pattern(regexp = "^[\\d\\w!.,\\-_#%&]+@[a-zA-Z-9_\\-.]+$", message = Constants.INVALID_EMAIL)
    private String email;

    @Pattern(regexp = "^\\d{4}$", message = Constants.INVALID_PASSWORD)
    private String password;

    private String confirmPassword;

    public RegisterModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
