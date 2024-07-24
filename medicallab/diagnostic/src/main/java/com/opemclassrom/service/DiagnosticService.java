package com.opemclassrom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.opemclassrom.model.FooNote;
import com.opemclassrom.model.FooPatient;

@Service
public class DiagnosticService {

    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://localhost:9003/patients";
    String fooResourceUrlNote = "http://localhost:9003/notes";


    public String getDiagnostic(  int id){
        String diagnos = "None" ;
        FooPatient patient = restTemplate.getForObject(fooResourceUrl + "/" + id, FooPatient.class);
        ResponseEntity<FooNote[]> response = restTemplate.getForEntity(fooResourceUrlNote + "/" + id, FooNote[].class);
        FooNote[] notesList = response.getBody();
        if(notesList == null || notesList.length == 0){
            return diagnos;
        }
        ArrayList<String> sympList = new ArrayList<>();
        sympList.add("Hémoglobine A1C");
        sympList.add("Microalbumine");
        sympList.add("Taille");
        sympList.add("Poids");
        sympList.add("Fumeur");
        sympList.add("Fumeuse");
        sympList.add("Anormal");
        sympList.add("Cholestérol");
        sympList.add("Vertiges");
        sympList.add("Rechute");
        sympList.add("Réaction");
        sympList.add("Anticorps");
       
        int symptomes = 0;
       
    for(int i = 0; i < sympList.size(); i = i + 1){
        Boolean isPresent = false;
        for(FooNote notes: notesList){
            if(notes.getNote().indexOf(sympList.get(i)) >= 0){
                isPresent = true;
            }
        }
        if(isPresent){
            symptomes = symptomes + 1;
        }
                
    }
      

    if((symptomes >= 2 && symptomes <= 5) && ((patient.getAge() >= 30 ) )){

        diagnos = "Borderline";
    }
    else if (((patient.getGenre() == "M") && (symptomes == 3 || symptomes == 4) && (patient.getAge() < 30)) ||
            ((patient.getGenre() == "F") && (symptomes >= 4 && symptomes <= 6) && (patient.getAge() <30)) ||
            ((patient.getAge() >= 30) && (symptomes >= 6 && symptomes <= 7) )) {

        
        diagnos = "In Danger";
    }

    else if (((patient.getGenre() == "M") && (symptomes >= 5) && (patient.getAge() < 30)) ||
            ((patient.getGenre() == "F") && (symptomes >=7) && (patient.getAge() <30))||
            ((patient.getAge() >= 30) && (symptomes >= 8) )) {

        diagnos = "Early onset";
    }
    return diagnos;
     }

}
