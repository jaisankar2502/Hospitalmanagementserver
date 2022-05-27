package com.hospitalmanagement.Hospitalmanagement.repository;

import com.hospitalmanagement.Hospitalmanagement.entity.Patient;
import com.hospitalmanagement.Hospitalmanagement.entity.User;
import com.hospitalmanagement.Hospitalmanagement.view.PatientView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;

public interface PatientRepository extends Repository<Patient, Integer>
{

        Patient save(Patient patient);


@Query(value = "SELECT * FROM patient WHERE book_date=?2 AND doctor_name=?1", nativeQuery = true)
    List<Patient> findTime(Integer doctorName, String date);


@Query(value = "SELECT count( distinct booking_id) From patient where doctor_name=?1", nativeQuery = true)
public Long patientCountForDoctor(Integer id);
@Query(value = "SELECT * FROM patient where doctor_name=?1 and book_date=?2",nativeQuery = true)
public List<Patient>findCurrentPatient(Integer id,String date);

}
