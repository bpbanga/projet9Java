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

    public List<Patient> getPatients( int idPrat){

        return patientRepository.findByIdPraticient(idPrat);
    }

    public Patient getPatient(int idPrat, int id){
           
         Optional <Patient> patient = patientRepository.findById(id);    
        
            if( patient.isPresent() && idPrat == patient.get().getIdPraticient()){
                return patient.get();
                
            }else{
                System.out.println("le praticient ne posséde pas ce patient");
                return null;
        } 

    }

    public Patient postPatient( int idPrat,Patient patient){
        patient.setIdPraticient(idPrat);
        return patientRepository.save(patient);
    }

    public Patient putPatient(int idPrat, int patientIDUp,String patientPrenomUp , String patientNomUp, Date patientDateNaisUp,
                           String patientGenreup, String patientAdresseUp, String patientNumTelUp){
        Optional <Patient> patientToUp = patientRepository.findById(patientIDUp);
        if (patientToUp.isPresent() && idPrat == patientToUp.get().getIdPraticient()){
            patientToUp.get().setPrenom(patientPrenomUp);
            patientToUp.get().setNom(patientNomUp);
            patientToUp.get().setDateNaiss(patientDateNaisUp);
            patientToUp.get().setGenre(patientGenreup);
            patientToUp.get().setAdresse(patientAdresseUp);
            patientToUp.get().setTelephone(patientNumTelUp);

            patientRepository.save(patientToUp.get());
            return patientToUp.get();
        }
        return null;
    }


}
