package com.hospitalmanagement.Hospitalmanagement.view;

import com.hospitalmanagement.Hospitalmanagement.entity.Patient;
import com.hospitalmanagement.Hospitalmanagement.json.Json;

import java.sql.Time;
import java.util.Date;

public class PatientView {
    private final  int Booking_Id;
    private final String PatientName;
    private final String Age;
    private final  String Email;
    private final String Phone;
    private  final String DepartmentName;
    private  final Integer DoctorName;

    private final String BookingDate;
    private  final String BookingTime;
    private  final byte status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateFormat
    private final Date updateDate;

    public PatientView(Patient patient){
        this.Booking_Id= patient.getBookingId();
        this.PatientName= patient.getPatientName();
        this.Age= patient.getAge();
        this.Email= patient.getEmail();
        this.Phone= patient.getPhone();
        this.BookingDate=patient.getBookDate();
        this.BookingTime=patient.getBookingTime();
        this.DepartmentName= patient.getDepartment();
        this.DoctorName= patient.getDoctorName();
        this.status= patient.getStatus();
        this.createDate= patient.getCreateDate();
        this.updateDate=patient.getUpdateDate();
    }



    public int getBooking_Id() {
        return Booking_Id;
    }

    public String getPatientName() {
        return PatientName;
    }

    public String getAge() {
        return Age;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public Integer getDoctorName() {
        return DoctorName;
    }

    public byte getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public String getBookingTime() {
        return BookingTime;
    }


}
