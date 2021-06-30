package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.FitnesCentar;
import com.exampleAplikacija.FitnesCentar.entity.Sala;
import com.exampleAplikacija.FitnesCentar.repository.FitnesCentarRepository;
import com.exampleAplikacija.FitnesCentar.repository.SalaRepository;
import com.exampleAplikacija.FitnesCentar.service.FitnesCentarService;
import com.exampleAplikacija.FitnesCentar.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SalaController {
    private final SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }
    @Autowired
    public SalaRepository srepo;
    @Autowired
    public FitnesCentarRepository frepo;
    @GetMapping(value = "/sveSale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Sala>> sveSale(@PathVariable Long id) {
        FitnesCentar f=this.frepo.findById(id).get();
        Set<Sala> sale=new HashSet<>();
        sale=f.getSale();


        return new ResponseEntity<>(sale, HttpStatus.OK);
    }
    @PostMapping("/obrisiSalu/{id}")
    public ResponseEntity<Void> obrisiSalu(@PathVariable Long id)
    {
        FitnesCentar f=this.frepo.findById(id).get();
        Sala sala=this.srepo.findById(id).get();
        Set<Sala> sale=new HashSet<>();
        sale=f.getSale();
        sale.remove(sala);
     f.setSale(sale);
        Sala sala2=new Sala(sala.getKapacitet(),sala.getOznaka_sale(),f);
        srepo.save(sala2);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
