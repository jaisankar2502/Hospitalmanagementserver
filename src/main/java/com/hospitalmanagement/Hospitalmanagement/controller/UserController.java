package com.hospitalmanagement.Hospitalmanagement.controller;


import com.hospitalmanagement.Hospitalmanagement.entity.Department;
import com.hospitalmanagement.Hospitalmanagement.entity.User;
import com.hospitalmanagement.Hospitalmanagement.form.DepartmentForm;
import com.hospitalmanagement.Hospitalmanagement.form.UserForm;
import com.hospitalmanagement.Hospitalmanagement.service.UserService;
import com.hospitalmanagement.Hospitalmanagement.view.DepartmentView;
import com.hospitalmanagement.Hospitalmanagement.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserView adduser(@RequestBody UserForm form) {
        return userService.add(form);
    }

    @PostMapping("/department")
    public DepartmentView addDepartment(@RequestBody DepartmentForm form) {

        return userService.add_Department(form);
    }

    @GetMapping("/department")
    public Collection<DepartmentView> list() {
        return userService.list();
    }

    @GetMapping("/doctor")
    public Collection<UserView> fetchUser() {
        return userService.fetchUser();
    }

    @GetMapping("/count")
    public Long getDoctorCount() {
        return userService.fetchUserCount();
    }

    @GetMapping("/doctor/{id}")
    public Collection<UserView> fetchCurrentDoctor(@PathVariable Integer id) {
        return userService.fetchCurrentDoctor(id);
    }
    @GetMapping("/patientDep")
        public Collection<DepartmentView>fetchDepartmentForPatient(){
            return userService.patientDep();
        }

}