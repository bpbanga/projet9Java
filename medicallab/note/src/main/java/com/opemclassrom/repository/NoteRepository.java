package com.opemclassrom.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.opemclassrom.model.Note;
import java.util.List;



public interface NoteRepository extends MongoRepository<Note, String>{

    List<Note> findByPatId(int patId);

}
