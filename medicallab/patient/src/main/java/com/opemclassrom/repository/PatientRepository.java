package com.opemclassrom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opemclassrom.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

    List <Patient> findByIdPraticient(int idPraticient);

}
