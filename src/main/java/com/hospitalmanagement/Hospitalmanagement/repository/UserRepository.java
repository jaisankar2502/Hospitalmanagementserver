package com.hospitalmanagement.Hospitalmanagement.repository;

import com.hospitalmanagement.Hospitalmanagement.entity.Department;
import com.hospitalmanagement.Hospitalmanagement.entity.User;
import com.hospitalmanagement.Hospitalmanagement.view.UserView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Integer> {
    User save(User user);


    Optional<User>findByEmail(String email);

    Collection<User>findAll();
    @Query(value = "SELECT count(distinct user_id) From user where type=2" ,nativeQuery = true)
    public Long count();

    @Query(value ="SELECT i FROM Department i  where i. DepId!=1 ")
    Collection<Department>findDoctor();
    @Query(value = "SELECT distinct *  FROM  user where dep_id = ?1", nativeQuery = true)
    Collection<User>findDoctorName(Integer id);


}
