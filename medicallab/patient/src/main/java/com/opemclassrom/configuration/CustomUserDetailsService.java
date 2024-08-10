package com.opemclassrom.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.opemclassrom.model.Patient;
import com.opemclassrom.repository.PatientRepository;

public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        try {
            Patient patient = patientRepository.findByNom(nom);
            String userName = patient.getNom();
            String password = patient.getMotDePasse();
            return new User(userName, password, new ArrayList<>());
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.toString());
        }
    }

}
