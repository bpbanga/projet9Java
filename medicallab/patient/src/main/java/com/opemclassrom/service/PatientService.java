package com.opemclassrom.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opemclassrom.model.Patient;
import com.opemclassrom.repository.PatientRepository;

@Service
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatient(int id){
         Optional <Patient> patient = patientRepository.findById(id);
		return patient.get();
    }

    public Patient postPatient( Patient patient){
        return patientRepository.save(patient);
    }

    public Patient putPatient(int patientIDUp,String patientPrenomUp , String patientNomUp, Date patientDateNaisUp,
                           String patientGenreup, String patientAdresseUp, String patientNumTelUp){
        Optional <Patient> patientToUp = patientRepository.findById(patientIDUp);
        if (patientToUp.isPresent()){
            patientToUp.get().setPrenom(patientPrenomUp);
            patientToUp.get().setNom(patientNomUp);
            patientToUp.get().setDateNaiss(patientDateNaisUp);
            patientToUp.get().setGenre(patientGenreup);
            patientToUp.get().setAdresse(patientAdresseUp);
            patientToUp.get().setTelephone(patientNumTelUp);
        }
        patientRepository.save(patientToUp.get());
        return patientToUp.get();

    }


}
