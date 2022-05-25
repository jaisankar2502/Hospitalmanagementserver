package com.hospitalmanagement.Hospitalmanagement.view;

import com.hospitalmanagement.Hospitalmanagement.entity.Patient;

public class Patienttimeslote {
    private  final String BookingTime;

    public Patienttimeslote(Patient patient) {
        BookingTime = patient.getBookingTime();
    }

    public String getBookingTime() {
        return BookingTime;
    }
}
