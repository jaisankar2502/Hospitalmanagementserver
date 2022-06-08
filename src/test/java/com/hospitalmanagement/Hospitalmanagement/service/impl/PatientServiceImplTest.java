package com.hospitalmanagement.Hospitalmanagement.service.impl;
import com.hospitalmanagement.Hospitalmanagement.entity.Patient;
import com.hospitalmanagement.Hospitalmanagement.form.PatientForm;
import com.hospitalmanagement.Hospitalmanagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceImplTest {
    @Autowired
    @InjectMocks
    private  PatientServiceImpl patientService;

    @MockBean
    @Autowired
    private PatientRepository repository;



    @Test
    void testAdd() {

        byte num=1;
        PatientForm patientForm= new PatientForm();
        patientForm.setBookingTime("9.30");
        patientForm.setBookDate("20-02-2022");
        patientForm.setPatientName("Arun");
        patientForm.setAge("20");
        patientForm.setDepartment("ortho");
        patientForm.setDoctorName(2);
        patientForm.setEmail("see@gmail.com");
        patientForm.setPhone("9072278138");


        Patient patient= new Patient();
        patient.setPatientName(patientForm.getPatientName());
        patient.setAge(patientForm.getAge());
        patient.setPhone(patientForm.getPhone());
        patient.setEmail(patientForm.getEmail());
        patient.setDepartment(patientForm.getDepartment());
        patient.setBookingTime(patientForm.getBookingTime());
        patient.setBookDate(patientForm.getBookDate());
        patient.setStatus(num);
        patient.setUpdateDate(new Date());
        patient.setCreateDate(new Date());
        patient.setBookingId(1);
        patient.setDoctorName(patientForm.getDoctorName());
        when(repository.save(patient)).thenReturn(patient);
        assertEquals(patient,patientService.add(patientForm));
    }
}