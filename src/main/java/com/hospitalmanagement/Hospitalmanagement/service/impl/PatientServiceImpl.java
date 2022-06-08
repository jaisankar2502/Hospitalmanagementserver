package com.hospitalmanagement.Hospitalmanagement.service.impl;

import com.hospitalmanagement.Hospitalmanagement.entity.Patient;
import com.hospitalmanagement.Hospitalmanagement.form.PatientForm;
import com.hospitalmanagement.Hospitalmanagement.repository.PatientRepository;
import com.hospitalmanagement.Hospitalmanagement.service.PatientService;
import com.hospitalmanagement.Hospitalmanagement.view.PatientView;
import com.hospitalmanagement.Hospitalmanagement.view.Patienttimeslote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientView add(PatientForm patientForm) {
        return new PatientView(patientRepository.save(new Patient(patientForm)));
    }

    @Override
    public List<Patienttimeslote> fetchTime(Integer doctorName, String bookDate) {
        return patientRepository.findTime(doctorName, bookDate).stream().map(Patienttimeslote::new).collect(Collectors.toList());

    }

    @Override
    public Long PatientCountForDoc(Integer id) {
        return  patientRepository.patientCountForDoctor(id);
    }

    @Override
    public List<PatientView> fetchCurrentPatient(Integer id, String date) {
        return patientRepository.findCurrentPatient(id,date).stream().map(PatientView::new).collect(Collectors.toList());
    }


}