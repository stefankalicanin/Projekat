package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.*;
import com.exampleAplikacija.FitnesCentar.entity.DTO.FCDTO;
import com.exampleAplikacija.FitnesCentar.entity.DTO.TrenerDTO;
import com.exampleAplikacija.FitnesCentar.entity.DTO.TreningDTO;
import com.exampleAplikacija.FitnesCentar.repository.*;
import com.exampleAplikacija.FitnesCentar.service.TrenerService;
import com.exampleAplikacija.FitnesCentar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class TreningController {
    private final TreningService treningService;
    @Autowired
    public LogInRepository repo;
    @Autowired
    public ClanRepository crepo;
    @Autowired
    public TreningRepository treningrepo;
    @Autowired
    public TerminRepository trepo;
    @Autowired
    public TrenerRepository trenerrepo;
    @Autowired
    public SalaRepository srepo;
    @Autowired
    public OcenaRepository orepo;
    @Autowired
    public TreningController(TreningService treningService) {
        this.treningService=treningService;
    }
    @GetMapping(value="/sviTreninzi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> sviTreninzi() {
        List<Trening> listaTreninga = this.treningService.sviTreninzi();
        return new ResponseEntity<>(listaTreninga, HttpStatus.OK);
    }
    @GetMapping(value="/sortiraniPoNazivu",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> treninziSortiraniPoNazivu() {
        List<Trening> listaTreninga = this.treningService.treninziSortiraniPoNazivu();
        return new ResponseEntity<>(listaTreninga, HttpStatus.OK);
    }
    @GetMapping(value="/sortiraniPoOpisu",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> treninziSortiraniPoOpisu() {
        List<Trening> listaTreninga = this.treningService.treninziSortiraniPoOpisu();
        return new ResponseEntity<>(listaTreninga, HttpStatus.OK);
    }
    @GetMapping(value="/sortiraniPoTipu",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> treninziSortiraniPoTipu() {
        List<Trening> listaTreninga = this.treningService.treninziSortiraniPoTipu();
        return new ResponseEntity<>(listaTreninga, HttpStatus.OK);
    }
    @GetMapping(value="/sortiraniPoTrajanju",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> treninziSortiraniPoTrajanju() {
        List<Trening> listaTreninga = this.treningService.treninziSortiraniPoTrajanju();
        return new ResponseEntity<>(listaTreninga, HttpStatus.OK);
    }

    @GetMapping(value = "/pretraziPoVise", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> pretraziTreningPoTrajanju(@RequestParam(required = false) String kljucnaRec1, @RequestParam(required = false) String kljucnaRec2,@RequestParam(required = false) String kljucnaRec3,@RequestParam(required = false) String kljucnaRec4) {
        List<Trening> trening=this.treningService.pretragaPoVise(kljucnaRec1,kljucnaRec2,kljucnaRec3,kljucnaRec4);


        return new ResponseEntity<>(trening, HttpStatus.OK);
    }
    @PostMapping(value="/dodajTermin/{id}/{id1}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Termin> dodajTermin(@RequestBody TreningDTO td,@PathVariable Long id,@PathVariable Long id1) throws Exception {
        Sala sala=this.srepo.getOne(id1);
        Trening trening=this.treningService.get(td.getTrening_id());
        Termin termin=new Termin(td.getRaspored_termina(),td.getBroj_prijavljenih_clanova(),td.getCena(),trening);
        trepo.save(termin);
        Trener trener=trenerrepo.getOne(id);
        trening.getLista_trenera().add(trener);
        trener.getLista_treninga().add(trening);
        sala.getTermini().add(termin);
        termin.getSale().add(sala);
        this.srepo.save(sala);
        this.treningrepo.save(trening);
        return new ResponseEntity<>(termin, HttpStatus.CREATED);
    }
    @GetMapping(value = "/sviTerminiT/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Termin>> sviTermini(@PathVariable Long id) {
        Trening trening=this.treningService.get(id);
        Set<Termin> termini=new HashSet<>();
       termini=trening.getRaspored_odrzavanja_treninga();

        return new ResponseEntity<>(termini, HttpStatus.OK);
    }
    @PostMapping("/izmeniTermin/{id}")
    public ResponseEntity<Void> izmeniTermin(@RequestBody Termin termin,@PathVariable Long id)
    {
        Termin termin1=this.trepo.getOne(id);
       termin1.setRaspored_termina(termin.getRaspored_termina());
       termin1.setBroj_prijavljenih_clanova(termin.getBroj_prijavljenih_clanova());
       termin1.setCena(termin.getCena());
       trepo.save(termin1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/sviPrijavljeniTreninzi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Trening>> prijavljeniTreninzi(@PathVariable Long id) {

        Clan clan=this.crepo.getOne(id);
        Set<Trening> trening=new HashSet<>();
       trening=clan.getLista_prijavljenih_treninga();
        return new ResponseEntity<>(trening, HttpStatus.OK);
    }
    @GetMapping(value = "/sviOdradjeniTreninzi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Trening>> odradjeniTreninzi(@PathVariable Long id) {

        Clan clan=this.crepo.getOne(id);
        Set<Trening> trening=new HashSet<>();
        trening=clan.getLista_odradjenih_treninga();
        return new ResponseEntity<>(trening, HttpStatus.OK);
    }
    @GetMapping(value = "/sviOcenjeniTreninzi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Trening>> ocenjeniTreninzi(@PathVariable Long id) {

   List<Ocena> ocene=this.orepo.ocene();
   Set<Trening> t=new HashSet<>();
   for(Ocena ocena:ocene)
   {
       t.add(ocena.getTrening());
   }
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
    @PostMapping("/otkaziTrening/{id}/{id1}")
    public ResponseEntity<Void> otkaziTrening(@PathVariable Long id,@PathVariable Long id1)
    {

        Trening trening=this.treningService.get(id);
        Clan clan=this.crepo.getOne(id1);
        trening.getPrijavljeni_treninzi().remove(clan);
        clan.getLista_prijavljenih_treninga().remove(trening);
        treningrepo.save(trening);
        Set<Termin> termini=trening.getRaspored_odrzavanja_treninga();
        for(Termin t:termini)
        {
           Integer bpc=t.getBroj_prijavljenih_clanova();
           bpc--;
           t.setBroj_prijavljenih_clanova(bpc);
          trepo.save(t);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/odradiTrening/{id}/{id1}")
    public ResponseEntity<Void> odradiTrening(@PathVariable Long id,@PathVariable Long id1)
    {
        Trening trening=this.treningService.get(id);
        Clan clan=this.crepo.getOne(id1);
        trening.getOdradjeni_treninzi().add(clan);
        clan.getLista_odradjenih_treninga().add(trening);
        treningrepo.save(trening);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/oceniTrening/{id}/{id1}/{id2}")
    public ResponseEntity<Void> oceniTrening(@PathVariable Long id,@PathVariable Long id1,@PathVariable String id2)
    {
        Trening trening=this.treningService.get(id);
        Clan clan=this.crepo.getOne(id1);
       Ocena ocena=new Ocena(id2,clan,trening);
       orepo.save(ocena);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
