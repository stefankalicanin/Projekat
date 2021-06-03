package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.FitnesCentar;
import com.exampleAplikacija.FitnesCentar.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdminController {
    private final FitnesCentarService fitnesCentarService;

    // constructor-based dependency injection
    @Autowired
    public AdminController(FitnesCentarService fitnesCentarService) {
        this.fitnesCentarService=fitnesCentarService;
    }
    @PostMapping(value="/dodajFitnesCentar",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentar> dodajFitnesCentar(@RequestBody FitnesCentar fitnesCentar) throws Exception {
        FitnesCentar noviFF = fitnesCentarService.sacuvaj(fitnesCentar);


        return new ResponseEntity<>(fitnesCentar, HttpStatus.CREATED);
    }

}
