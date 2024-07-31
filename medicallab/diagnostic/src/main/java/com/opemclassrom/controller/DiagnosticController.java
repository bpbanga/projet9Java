package com.opemclassrom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opemclassrom.service.DiagnosticService;

@RestController
@RequestMapping("diagnostics")
public class DiagnosticController {

    @Autowired
    private DiagnosticService diagnosticService;

    @GetMapping("/{idPrat}/{id}")
    public String getPatients(@PathVariable int idPrat ,@PathVariable int id){
       
        return diagnosticService.getDiagnostic(idPrat, id);
    }




}
