package com.opemclassrom.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.opemclassrom.model.Note;

import java.util.ArrayList;



public interface NoteRepository extends MongoRepository<Note, String>{

    ArrayList<Note> findByPatId(int patId);


}
