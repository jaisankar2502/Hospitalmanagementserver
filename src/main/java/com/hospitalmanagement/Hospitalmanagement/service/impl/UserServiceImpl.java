package com.hospitalmanagement.Hospitalmanagement.service.impl;

import com.hospitalmanagement.Hospitalmanagement.entity.Department;
import com.hospitalmanagement.Hospitalmanagement.entity.User;
import com.hospitalmanagement.Hospitalmanagement.exception.BadRequestException;
import com.hospitalmanagement.Hospitalmanagement.exception.NotFoundException;
import com.hospitalmanagement.Hospitalmanagement.form.DepartmentForm;
import com.hospitalmanagement.Hospitalmanagement.form.LoginForm;
import com.hospitalmanagement.Hospitalmanagement.form.UserForm;
import com.hospitalmanagement.Hospitalmanagement.repository.DepartmentRepository;
import com.hospitalmanagement.Hospitalmanagement.repository.UserRepository;
import com.hospitalmanagement.Hospitalmanagement.security.config.SecurityConfig;
import com.hospitalmanagement.Hospitalmanagement.security.util.TokenGenerator;
import com.hospitalmanagement.Hospitalmanagement.service.UserService;
import com.hospitalmanagement.Hospitalmanagement.view.DepartmentView;
import com.hospitalmanagement.Hospitalmanagement.view.LoginView;
import com.hospitalmanagement.Hospitalmanagement.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import com.hospitalmanagement.Hospitalmanagement.security.util.TokenGenerator.Token;

import java.util.*;
import java.util.stream.Collectors;

import static com.hospitalmanagement.Hospitalmanagement.security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;


@Service
public class UserServiceImpl implements UserService {

    private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";
    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenGenerator tokenGenerator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    User user;

    private static BadRequestException badRequestException() {
        return new BadRequestException("Invalid Login");
    }


    @Override
    public UserView add(UserForm form) {
        return new UserView(userRepository.save(new User(form)));
    }

    @Override
    public DepartmentView add_Department(DepartmentForm form) {
        return new DepartmentView(departmentRepository.save(new Department(form)));
    }

    @Override
    public LoginView login(LoginForm loginForm, Errors errors) throws BadRequestException {
        if (errors.hasErrors()) {
            throw badRequestException();
        }
        User user = userRepository.findByEmail(loginForm.getEmail()).orElseThrow(UserServiceImpl::badRequestException);
        if (!Objects.equals(loginForm.getPassword(), user.getPassword())) {
            throw badRequestException();
        }

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + user.getPassword(), securityConfig.getRefreshTokenExpiry());
        return new LoginView(user, accessToken, refreshToken);
    }

    @Override
    public Collection<DepartmentView> list() {
        ArrayList<Department>departmentview = (ArrayList<Department>) departmentRepository.findAll();
        return departmentview.stream().map(item->new DepartmentView(item)).collect(Collectors.toList());
    }

    @Override
    public Collection<UserView> fetchUser() {
        ArrayList<User>userview= (ArrayList<User>) userRepository.findAll();
        return userview.stream().map(item->new UserView(item)).collect(Collectors.toList());
    }
//    @Override
//    public Collection<DepartmentView> fetchUser() {
//        ArrayList<Department>userview= (ArrayList<Department>) userRepository.findDoctor();
//        return userview.stream().map(item->new DepartmentView(item)).collect(Collectors.toList());
//    }

    @Override
    public Long fetchUserCount() {
      return userRepository.count();
    }

    @Override
    public Collection<UserView> fetchCurrentDoctor(Integer Id) {
        ArrayList<User>userview=(ArrayList<User>) userRepository.findDoctorName(Id);

        return userview.stream().map(UserView::new).collect(Collectors.toList());
    }

    @Override
    public Collection<DepartmentView> patientDep() {
      ArrayList<Department>Doctor=(ArrayList<Department>) departmentRepository.doctor();
      return Doctor.stream().map(DepartmentView::new).collect(Collectors.toList());
    }


}
