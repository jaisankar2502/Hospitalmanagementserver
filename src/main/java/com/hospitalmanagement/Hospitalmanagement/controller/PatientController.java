package com.hospitalmanagement.Hospitalmanagement.controller;

import com.hospitalmanagement.Hospitalmanagement.form.PatientForm;
import com.hospitalmanagement.Hospitalmanagement.service.PatientService;
import com.hospitalmanagement.Hospitalmanagement.view.PatientView;
import com.hospitalmanagement.Hospitalmanagement.view.Patienttimeslote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {


  @Autowired
  private PatientService patientService;


  @PostMapping
    public PatientView add_Patient(@RequestBody PatientForm patientForm) {
    return patientService.add(patientForm);
  }

    @GetMapping("/time")
    public List<Patienttimeslote> etchTime(@RequestParam Integer docid, @RequestParam  String date){

    return patientService.fetchTime(docid,date);
    }








}
