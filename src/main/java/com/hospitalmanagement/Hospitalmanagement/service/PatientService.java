package com.hospitalmanagement.Hospitalmanagement.service;

import com.hospitalmanagement.Hospitalmanagement.entity.Patient;
import com.hospitalmanagement.Hospitalmanagement.form.PatientForm;
import com.hospitalmanagement.Hospitalmanagement.view.PatientView;
import com.hospitalmanagement.Hospitalmanagement.view.Patienttimeslote;

import java.util.Collection;
import java.util.List;

public interface PatientService {
    PatientView add(PatientForm patientForm);



    List<Patienttimeslote> fetchTime(Integer doctorName, String bookDate);

    Long PatientCountForDoc(Integer id);

    List<PatientView> fetchCurrentPatient(Integer id, String date);
}
