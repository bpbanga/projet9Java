package com.opemclassrom.service;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.opemclassrom.model.FooNote;
import com.opemclassrom.model.FooPatient;

@Service
public class FrontService {

    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://localhost:9003/patients/{idPrat}";
    String fooResourceUrlNote = "http://localhost:9003/notes";


    public FooPatient[] getPatients(){
        ResponseEntity<FooPatient[]> reponse = restTemplate.getForEntity(fooResourceUrl, FooPatient[].class);
        FooPatient[] patients = reponse.getBody(); 
        return patients;
        
    }

    public FooPatient getPatient(  int id){
        FooPatient response = restTemplate.getForObject(fooResourceUrl + "/" + id, FooPatient.class);
        return response;
    }

    public FooNote[] getNote(  int id){
        ResponseEntity<FooNote[]> response = restTemplate.getForEntity(fooResourceUrlNote + "/" + id, FooNote[].class);
        FooNote[] notes = response.getBody();
        return notes;
    }

    public FooNote postNote(FooNote noteToAdd){
        HttpEntity<FooNote> request = new HttpEntity<>(noteToAdd);
        FooNote foo = restTemplate.postForObject(fooResourceUrlNote, request, FooNote.class);
        return foo;
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
