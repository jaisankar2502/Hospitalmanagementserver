package com.hospitalmanagement.Hospitalmanagement.entity;

import com.hospitalmanagement.Hospitalmanagement.form.PatientForm;

import javax.persistence.*;
import java.sql.*;
import java.util.Date;

@Entity
public class Patient {
    public Patient() {
    }

    public  static  enum Status{
        INACTIVE((byte)0),
        ACTIVE((byte)1);
        public final  byte value;
        private Status(byte value){
            this.value= value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookingId;

    private  String PatientName;

    private String Age;

    private String Email;

    private String Phone;

    private String Department;

    private Integer DoctorName;

    private  String  BookDate;

    private String BookingTime;

    private byte status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Patient(Integer BookingId)
    {
        this.BookingId=BookingId;

    }
    public Patient(PatientForm form){
        this.PatientName= form.getPatientName();
        this.Age= form.getAge();
        this.Email= form.getEmail();
        this.Phone= form.getPhone();
        this.Department= form.getDepartment();
        this.DoctorName= form.getDoctorName();
        this.BookDate= form.getBookDate();
        this.BookingTime= form.getBookingTime();
        Date dt= new Date();
        this.createDate= dt;
        this.updateDate=dt;
        this.status= Status.ACTIVE.value;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Integer getBookingId() {
        return BookingId;
    }

    public void setBookingId(Integer bookingId) {
        BookingId = bookingId;
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


    public Integer getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(Integer doctorName) {
        DoctorName = doctorName;
    }



    public String getBookingTime() {
        return BookingTime;
    }

    public void setBookingTime(String bookingTime) {
        BookingTime = bookingTime;
    }

    public Date getCreateDate() {
        return createDate;
    }


    public String getBookDate() {
        return BookDate;
    }

    public void setBookDate(String bookDate) {
        BookDate = bookDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
