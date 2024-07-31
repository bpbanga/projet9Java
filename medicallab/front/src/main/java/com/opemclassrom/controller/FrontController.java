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
    @GetMapping("/list/{idPrat}")
    public String home(@PathVariable("idPrat") Integer idPrat ,Model model) {

        FooPatient[] patientLists = frontService.getPatients(idPrat);
        model.addAttribute("patientLists", patientLists);
        model.addAttribute("idPrat", idPrat);
        logger.info("Returning list page");
        return "List";
    }

    @GetMapping("/list/{idPrat}/{id}")
    public String getStringPatient(@PathVariable("idPrat") Integer idPrat ,@PathVariable("id") Integer id,  Model model) {
        FooPatient patient = frontService.getPatient(idPrat , id);
        FooNote[] notes = frontService.getNote(id);
        String diagnostic =frontService.getDiagnostic(idPrat, id);
        model.addAttribute("patient", patient);
        model.addAttribute("idPrat", idPrat);
        model.addAttribute("notes", notes);
        model.addAttribute("diagnostic", diagnostic);
        model.addAttribute("noteAdd", new FooNote(String.valueOf(id), patient.getNom(), null));
        logger.info("Returning patient's page");
        return "Patient";
    }
    

    @GetMapping("/{idPrat}/add")
    public String addPatientForm(@PathVariable("idPrat") Integer idPrat ,Model model) {

        model.addAttribute("patient", new FooPatient());
        model.addAttribute("idPrat", idPrat);
        logger.info("Retturning add page");
        return "Add";
    }

    @PostMapping("/{idPrat}/validate")
    public String validate(@PathVariable("idPrat") Integer idPrat , @Valid FooPatient patient, BindingResult result, Model model) {
  

        if (!result.hasErrors()) { 
            logger.info("Returning patient/add page");
		model.addAttribute("patient", patient);
		frontService.postPatient(idPrat , patient);
        
        return "redirect:/list/" + idPrat;	
		}
               logger.info("error Redirect: /add");
               model.addAttribute("patient", patient);
        return "Add";
    }

    @PostMapping("/{idPrat}/addNote")
    public String postNote(@PathVariable("idPrat") Integer idPrat , @Valid FooNote noteAdd, BindingResult result, Model model) {
  

        if (!result.hasErrors()) { 
            logger.info("Returning Fiche/addNote page");
		model.addAttribute("noteAdd", noteAdd);
		frontService.postNote(noteAdd);
        
        return "redirect:/list/"+ idPrat + "/" + noteAdd.getPatId();	
		}
               logger.info("error Redirect: /fihce");
               model.addAttribute("note", noteAdd);
        return "Add";
    }

     @GetMapping("/{idPrat}/update/{id}")
    public String showUpdateForm(@PathVariable("idPrat") Integer idPrat , @PathVariable("id") Integer id, Model model) {
        FooPatient patient = frontService.getPatient(idPrat , id);
        model.addAttribute("idPrat", idPrat);
        model.addAttribute("patient", patient);
        return "Update";
    }
    
    @PostMapping("/{idPrat}/changePatient")
    public String putMethodName( @PathVariable("idPrat") Integer idPrat , @Valid FooPatient patient, BindingResult result, Model model) {
        

        if (!result.hasErrors()) { 
            logger.info("Returning patient/update page");
		model.addAttribute("patient", patient);
		frontService.putPatient(idPrat , patient);
        
        return "redirect:/list/" + idPrat;	
		}
               logger.info("error Redirect: /update");
               model.addAttribute("patient", patient);
        return "Update";
        
        
    }

}
