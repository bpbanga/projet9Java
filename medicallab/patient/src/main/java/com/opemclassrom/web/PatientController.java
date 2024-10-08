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

    @GetMapping("/{idPrat}")
    public List<Patient> getPatients(@PathVariable int idPrat){
       
        return patientService.getPatients(idPrat);
    }

    @GetMapping("/{idPrat}/{id}")
    public Patient getPatient(@PathVariable int idPrat, @PathVariable int id){
        return patientService.getPatient(idPrat, id);
    }

    @PostMapping("/{idPrat}")
    public Patient addPatient( @PathVariable int idPrat, @RequestBody Patient patient){
        return patientService.postPatient(idPrat, patient);
	}

    @PutMapping("/{idPrat}")
    public Patient putPatient(@PathVariable int idPrat , @RequestBody Patient patient){
        return patientService.putPatient(idPrat, patient.getId(), patient.getPrenom(),patient.getNom() ,
                                         patient.getDateNaiss() , patient.getGenre(), patient.getAdresse(), patient.getTelephone());

    }

    }






