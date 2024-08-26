package com.opemclassrom.service;

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
    String fooResourceUrlPat = "http://patient:9003/patients";
    String fooResourceUrlNote = "http://note:9003/notes";
    String fooResourceUrlDiagnos = "http://diagnostic:9006/diagnostics";


    public FooPatient[] getPatients( int idPrat){
        ResponseEntity<FooPatient[]> reponse = restTemplate.getForEntity(fooResourceUrlPat + "/" + idPrat , FooPatient[].class);
        FooPatient[] patients = reponse.getBody(); 
        return patients;
        
    }

    public FooPatient getPatient( int idPrat, int id){
        FooPatient response = restTemplate.getForObject(fooResourceUrlPat + "/" + idPrat + "/" + id , FooPatient.class);
        return response;
    }

    public FooNote[] getNote(  int id){
        ResponseEntity<FooNote[]> response = restTemplate.getForEntity(fooResourceUrlNote + "/" + id, FooNote[].class);
        FooNote[] notes = response.getBody();
        return notes;
    }

    public String getDiagnostic( int idPrat, int id){
        String diagnos = restTemplate.getForObject(fooResourceUrlDiagnos + "/" + idPrat + "/" + id , String.class );
        return diagnos;
    }

    public FooNote postNote(FooNote noteToAdd){
        HttpEntity<FooNote> request = new HttpEntity<>(noteToAdd);
        FooNote foo = restTemplate.postForObject(fooResourceUrlNote, request, FooNote.class);
        return foo;
    }

    public FooPatient postPatient( int idPrat, FooPatient patientToAdd){
        HttpEntity<FooPatient> request = new HttpEntity<>(patientToAdd);
        FooPatient foo = restTemplate.postForObject(fooResourceUrlPat + "/" + idPrat , request, FooPatient.class);
        return foo;
    }

    public FooPatient putPatient(int idPrat ,FooPatient patientToUp){
        HttpEntity<FooPatient> request = new HttpEntity<>(patientToUp);
        HttpEntity<FooPatient> foo = restTemplate.exchange(fooResourceUrlPat + "/" + idPrat , HttpMethod.PUT, request, FooPatient.class);
       return foo.getBody() ;
    }
}
