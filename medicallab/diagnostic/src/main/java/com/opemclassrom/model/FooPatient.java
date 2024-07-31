package com.opemclassrom.model;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class FooPatient   {

    
    private int id;

    
    private String prenom;

    private String nom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaiss;

    private String genre;

    private String adresse;

    private String telephone;

    

    public FooPatient(int id, String prenom, String nom, Date dateNaiss, String genre, String adresse,
            String telephone) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaiss = dateNaiss;
        this.genre = genre;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public FooPatient() {
        //TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
