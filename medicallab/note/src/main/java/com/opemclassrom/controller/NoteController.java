package com.opemclassrom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opemclassrom.model.Note;
import com.opemclassrom.repository.NoteRepository;
import com.opemclassrom.service.NoteService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}")
    public List<Note> getAllNoteById(@PathVariable  int id){
        return noteService.getNotes(id); 
    }
    
    @PostMapping("")
    public Note AddNote(@RequestBody Note note ) {
        
        return noteService.postNote(note);
    }

    

}
