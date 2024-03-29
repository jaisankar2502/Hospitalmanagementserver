package com.hospitalmanagement.Hospitalmanagement.service.impl;
import com.hospitalmanagement.Hospitalmanagement.entity.Patient;
import com.hospitalmanagement.Hospitalmanagement.form.PatientForm;
import com.hospitalmanagement.Hospitalmanagement.repository.PatientRepository;
import com.hospitalmanagement.Hospitalmanagement.view.PatientView;
import com.hospitalmanagement.Hospitalmanagement.view.Patienttimeslote;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class PatientServiceImplTest  {
    @Autowired
    @InjectMocks
    private  PatientServiceImpl patientService;

    @MockBean
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
       doReturn(patient).when(repository).save(any());
       PatientView patientView= new PatientView(patient);
       assertEquals(patientView.getPatientName(),patientService.add(patientForm).getPatientName());
        System.out.println(patientView.getPatientName());
        System.out.println(patientService.add(patientForm).getPatientName());


//        System.out.println("test 2 called");
//        Patient patient1= repository.save(patient);
//        assertEquals(patientForm.getPatientName(), patient1.getPatientName());



    }




    @Test
    void fetchTime() {
        Integer doctorId=2;
        String BookingDate="20-02-2020";
        byte num=1;
        PatientForm patientForm= new PatientForm();
        patientForm.setBookingTime("9.30");
        patientForm.setBookDate("20-02-2020");
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
        doReturn(patient).when(repository).save(any());
        doReturn( List.of(patient)).when(repository).findTime(doctorId,BookingDate);
        Patienttimeslote patienttimeslote= new Patienttimeslote(patient);
        System.out.println( patienttimeslote.getBookingTime());
        assertEquals(1,List.of(patienttimeslote).size());
        System.out.println( List.of(patienttimeslote).size());



    }

    @Test
    void patientCountForDoc() {
        byte num=1;
        Integer doc=1;
        PatientForm patientForm= new PatientForm();
        patientForm.setBookingTime("9.30");
        patientForm.setBookDate("20-02-2020");
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
        doReturn(patient).when(repository).save(any());
        doReturn(patient).when(repository).patientCountForDoctor(doc);



        // @Override
        //    public Long PatientCountForDoc(Integer id) {
        //        return  patientRepository.patientCountForDoctor(id);
        //    }

    }
}