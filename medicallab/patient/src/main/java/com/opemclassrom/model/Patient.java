package com.opemclassrom.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_naiss")
    private Date dateNaiss;

    @Column(name = "genre")
    private String genre;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

}
