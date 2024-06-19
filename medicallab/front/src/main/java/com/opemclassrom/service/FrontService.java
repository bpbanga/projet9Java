package com.opemclassrom.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.opemclassrom.model.FooPatient;

@Service
public class FrontService {

    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://localhost:9003/patients";


    public FooPatient[] getPatients(){
        ResponseEntity<FooPatient[]> reponse = restTemplate.getForEntity(fooResourceUrl, FooPatient[].class);
        FooPatient[] patients = reponse.getBody(); 
        return patients;
        
    }

    public FooPatient getPatient(  int id){
        FooPatient response = restTemplate.getForObject(fooResourceUrl + "/" + id, FooPatient.class);
        return response;
    }

    public FooPatient postPatient(FooPatient patientToAdd){
        HttpEntity<FooPatient> request = new HttpEntity<>(patientToAdd);
        FooPatient foo = restTemplate.postForObject(fooResourceUrl, request, FooPatient.class);
        return foo;
    }

    public FooPatient putPatient(FooPatient patientToUp){
        HttpEntity<FooPatient> request = new HttpEntity<>(patientToUp);
        HttpEntity<FooPatient> foo = restTemplate.exchange(fooResourceUrl, HttpMethod.PUT, request, FooPatient.class);
       return foo.getBody() ;
    }



}
