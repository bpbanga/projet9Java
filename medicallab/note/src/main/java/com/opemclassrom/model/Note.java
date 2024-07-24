package com.opemclassrom.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    public int getPatId() {
        return patId;
    }

    public void setPatId(int patId) {
        this.patId = patId;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
   
    public String getNote() {
       
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Note [patId=" + patId + ", patient=" + patient + ", note=" + note + "]";
    }
   


}
