package com.hospitalmanagement.Hospitalmanagement.repository;

import com.hospitalmanagement.Hospitalmanagement.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Collection;

public interface DepartmentRepository extends Repository<Department ,Integer> {
    Department save(Department department);
    Collection<Department>findAll();
@Query(value = "SELECT * FROM department where type=2",nativeQuery = true)
    Collection<Department>doctor();


    
}
