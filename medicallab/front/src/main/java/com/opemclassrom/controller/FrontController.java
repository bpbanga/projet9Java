package com.opemclassrom.controller;
import com.opemclassrom.model.FooNote;
import com.opemclassrom.model.FooPatient;
import com.opemclassrom.service.FrontService;

import jakarta.validation.Valid;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class FrontController {

    @Autowired
	private FrontService frontService;
    
    private static final Logger logger = LogManager.getLogger("FrontController");
    @GetMapping("/list")
    public String home(Model model) {

        FooPatient[] patientLists = frontService.getPatients();
        model.addAttribute("patientLists", patientLists);
        logger.info("Returning list page");
        return "List";
    }

    @GetMapping("/list/{id}")
    public String getStringPatient(@PathVariable("id") Integer id,  Model model) {
        FooPatient patient = frontService.getPatient(id);
        FooNote[] notes = frontService.getNote(id);
        model.addAttribute("patient", patient);
        model.addAttribute("notes", notes);
        model.addAttribute("noteAdd", new FooNote(String.valueOf(id), patient.getNom(), null));
        logger.info("Returning patient's page");
        return "Patient";
    }
    

    @GetMapping("/add")
    public String addPatientForm(Model model) {

        model.addAttribute("patient", new FooPatient());
        logger.info("Retturning add page");
        return "Add";
    }

    @PostMapping("/validate")
    public String validate(@Valid FooPatient patient, BindingResult result, Model model) {
  

        if (!result.hasErrors()) { 
            logger.info("Returning patient/add page");
		model.addAttribute("patient", patient);
		frontService.postPatient(patient);
        
        return "redirect:list";	
		}
               logger.info("error Redirect: /add");
               model.addAttribute("patient", patient);
        return "Add";
    }

    @PostMapping("/addNote")
    public String postNote(@Valid FooNote noteAdd, BindingResult result, Model model) {
  

        if (!result.hasErrors()) { 
            logger.info("Returning Fiche/addNote page");
		model.addAttribute("noteAdd", noteAdd);
		frontService.postNote(noteAdd);
        
        return "redirect:list/" + noteAdd.getPatId();	
		}
               logger.info("error Redirect: /fihce");
               model.addAttribute("note", noteAdd);
        return "Add";
    }

     @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        FooPatient patient = frontService.getPatient(id);
        model.addAttribute("patient", patient);
        return "Update";
    }
    
    @PostMapping("/changePatient")
    public String putMethodName( @Valid FooPatient patient, BindingResult result, Model model) {
        

        if (!result.hasErrors()) { 
            logger.info("Returning patient/update page");
		model.addAttribute("patient", patient);
		frontService.putPatient(patient);
        
        return "redirect:list";	
		}
               logger.info("error Redirect: /update");
               model.addAttribute("patient", patient);
        return "Update";
        
        
    }

}
