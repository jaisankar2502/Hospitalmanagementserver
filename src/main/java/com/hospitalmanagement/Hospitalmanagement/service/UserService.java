package com.hospitalmanagement.Hospitalmanagement.service;

import com.hospitalmanagement.Hospitalmanagement.exception.BadRequestException;
import com.hospitalmanagement.Hospitalmanagement.form.DepartmentForm;
import com.hospitalmanagement.Hospitalmanagement.form.LeaveForm;
import com.hospitalmanagement.Hospitalmanagement.form.LoginForm;
import com.hospitalmanagement.Hospitalmanagement.form.UserForm;
import com.hospitalmanagement.Hospitalmanagement.view.*;
import org.springframework.validation.Errors;

import java.util.Collection;
import java.util.List;


public interface UserService {


    UserView add(UserForm form);
    DepartmentView add_Department(DepartmentForm form);
    LoginView login(LoginForm loginForm, Errors errors) throws BadRequestException;

    Collection<DepartmentView> list();

    Collection<UserView> fetchUser();

    Long fetchUserCount();

    Collection<UserView> fetchCurrentDoctor(Integer Id);

    Collection<DepartmentView> patientDep();


    LeaveView applyleave(LeaveForm leaveForm);

    List<LeaveView> fechLeave(Integer id);

    List<LeaveView> fetchLeaveDetails();

    LeaveView approveLeave(Integer leaveId);
    LeaveView leaveDoctor(Integer userId, String date);
}
