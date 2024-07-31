package com.opemclassrom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opemclassrom.model.Note;
import com.opemclassrom.repository.NoteRepository;

@Service
public class NoteService {

     @Autowired
    private NoteRepository noteRepository;


    public List<Note> getNotes( int id){

        ArrayList<Note> listNotes = new ArrayList<Note>(); 
       listNotes = noteRepository.findByPatId(id);     
        
        return listNotes;
    }

    public Note postNote( Note note){
        return noteRepository.save(note);
    }

}
