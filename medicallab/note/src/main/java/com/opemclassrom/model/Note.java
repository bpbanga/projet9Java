package com.opemclassrom.model;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document
public class Note {

    
    private int patId;

    private String patient;

    private String note;

 public Note(String patient, String note) {
        super();
        this.patient = patient;
        this.note = note;
    }  

    @Override
    public String toString() {
        return "Note [patId=" + patId + ", patient=" + patient + ", note=" + note + "]";
    }
   


}
