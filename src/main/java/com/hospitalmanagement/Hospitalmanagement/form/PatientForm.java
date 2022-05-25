package com.hospitalmanagement.Hospitalmanagement.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

public class PatientForm {
    @Size(max=30)
    private String PatientName;
    @Size(max=2)

    private String Age;
    @Email

    private String Email;
    @Size(max=10)

    private String Phone;

    private String Department;
    @Size(max=20)
    private Integer DoctorName;

    private String BookingDate;
    private String BookingTime;

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }

    public String getBookingTime() {
        return BookingTime;
    }

    public void setBookingTime(String bookingTime) {
        BookingTime = bookingTime;
    }


    public Integer getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(Integer doctorName) {
        DoctorName = doctorName;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }


}
