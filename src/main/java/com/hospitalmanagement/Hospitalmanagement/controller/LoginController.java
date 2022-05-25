package com.hospitalmanagement.Hospitalmanagement.controller;

import com.hospitalmanagement.Hospitalmanagement.form.LoginForm;
import com.hospitalmanagement.Hospitalmanagement.service.UserService;
import com.hospitalmanagement.Hospitalmanagement.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class LoginController {
    @Autowired
    private UserService userService;


    @PostMapping
    public LoginView login(@RequestBody LoginForm loginForm, Errors errors){
        return userService.login(loginForm,errors);
    }




}
