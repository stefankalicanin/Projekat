package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.DTO.TrenerDTO;
import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.entity.Trening;
import com.exampleAplikacija.FitnesCentar.repository.LogInRepository;
import com.exampleAplikacija.FitnesCentar.service.TrenerService;
import com.exampleAplikacija.FitnesCentar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TreningController {
    private final TreningService treningService;
    @Autowired
    public LogInRepository repo;

    @Autowired
    public TreningController(TreningService treningService) {
        this.treningService=treningService;
    }
    @GetMapping(value = "/pretraziPoNazivu/{kljucnaRec}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> pretraziTreningPoNazivu(@PathVariable("kljucnaRec") String kljucnaRec) {
       List<Trening> trening=this.treningService.pretragaTreningaPoNazivu(kljucnaRec);


        return new ResponseEntity<>(trening, HttpStatus.OK);
    }
    @GetMapping(value = "/pretraziPoOpisu/{kljucnaRec}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> pretraziTreningPoOpisu(@PathVariable("kljucnaRec") String kljucnaRec) {
        List<Trening> trening=this.treningService.pretragaTreningaPoOpisu(kljucnaRec);


        return new ResponseEntity<>(trening, HttpStatus.OK);
    }
    @GetMapping(value = "/pretraziPoTipuTreninga/{kljucnaRec}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> pretraziTreningPoTipu(@PathVariable("kljucnaRec") String kljucnaRec) {
        List<Trening> trening=this.treningService.pretragaTreningaPoTipu(kljucnaRec);


        return new ResponseEntity<>(trening, HttpStatus.OK);
    }
    @GetMapping(value = "/pretraziPoTrajanju/{kljucnaRec}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> pretraziTreningPoTrajanju(@PathVariable("kljucnaRec") String kljucnaRec) {
        List<Trening> trening=this.treningService.pretragaTreningaPoTrajanju(kljucnaRec);


        return new ResponseEntity<>(trening, HttpStatus.OK);
    }
    @GetMapping(value = "/pretraziPoCeni/{kljucnaRec}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> pretraziTreningPoCeni(@PathVariable("kljucnaRec") String kljucnaRec) {
        List<Trening> trening=this.treningService.pretragaTreningaPoCeni(kljucnaRec);


        return new ResponseEntity<>(trening, HttpStatus.OK);
    }
}
