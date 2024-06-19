package com.opemclassrom.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opemclassrom.model.Patient;
import com.opemclassrom.service.PatientService;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable int id){
        return patientService.getPatient(id);
    }



    @PostMapping("")
    public Patient addPatient( @RequestBody Patient patient){
        return patientService.postPatient(patient);
	}

    @PutMapping("")
    public Patient putPatient( @RequestBody Patient patient){
        return patientService.putPatient(patient.getId(), patient.getPrenom(),patient.getNom() ,
                                         patient.getDateNaiss() , patient.getGenre(), patient.getAdresse(), patient.getTelephone());

    }
     
    
    }






