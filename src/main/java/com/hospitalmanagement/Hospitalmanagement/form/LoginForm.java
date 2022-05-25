package com.hospitalmanagement.Hospitalmanagement.form;

import com.hospitalmanagement.Hospitalmanagement.form.validation.Password;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {
    @NotBlank
    @Size(max=30)
    @Email
    private  String email;

    @Password
    private String password;

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
}
