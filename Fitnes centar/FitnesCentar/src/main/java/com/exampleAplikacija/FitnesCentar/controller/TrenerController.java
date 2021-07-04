package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import com.exampleAplikacija.FitnesCentar.entity.DTO.TrenerDTO;
import com.exampleAplikacija.FitnesCentar.entity.FitnesCentar;
import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.repository.FitnesCentarRepository;
import com.exampleAplikacija.FitnesCentar.repository.LogInRepository;
import com.exampleAplikacija.FitnesCentar.repository.TrenerDtoRepository;
import com.exampleAplikacija.FitnesCentar.repository.TrenerRepository;
import com.exampleAplikacija.FitnesCentar.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TrenerController {
    private final TrenerService trenerService;
    @Autowired
    public LogInRepository repo;
    @Autowired
    public TrenerRepository trepo;
    @Autowired
    public TrenerDtoRepository trenerDtoRepository;
    @Autowired
    public FitnesCentarRepository frepo;
    @Autowired
    public TrenerController(TrenerService trenerService) {
        this.trenerService=trenerService;
    }
    @GetMapping("/registracija_trenera.html")
    public String getRegistracijaTrenera(Model model)
    {
        model.addAttribute("trener",new TrenerDTO());
        return "registracija_trenera";
    }
    @PostMapping("/registracija_trenera")
    public String procesRegistracijeTrenera(TrenerDTO trener)
    {

      trenerDtoRepository.save(trener);
        return "index";
    }
    @GetMapping(value="/sviTreneri",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getTreneri() {

        List<TrenerDTO> listaTrenera = this.trenerDtoRepository.findAll();
        return new ResponseEntity<>(listaTrenera, HttpStatus.OK);
    }
    @GetMapping(value="/sviTreneri1",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trener>> getTreneri1() {

        List<Trener> listaTrenera = this.trenerService.sviTreneri();
        return new ResponseEntity<>(listaTrenera, HttpStatus.OK);
    }

    @PostMapping("/izmeni/{id}")
    public ResponseEntity<Void> potvrdiTrenera(@PathVariable Long id)
    {
       TrenerDTO trener=this.trenerDtoRepository.findById(id).get();
       trener.setAktivan("da");
        String ime=trener.getKorisnicko_ime();
        String lozinka=trener.getLozinka();
        String prezime=trener.getPrezime();
        String uloga="trener";
        String aktivan=trener.getAktivan();
        LogInKorisnika korisnik=new LogInKorisnika(ime,lozinka,"trener","da");
        repo.save(korisnik);
        Trener noviTrener=new Trener(trener.getKorisnicko_ime(),trener.getLozinka(),trener.getIme(),trener.getPrezime(),trener.getKontakt_telefon(),trener.getEmail(),trener.getDatum_rodjenja(),"trener","da");
       trenerService.kreiraj(noviTrener);
        trenerDtoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/izmeni1/{id}")
    public ResponseEntity<Void> ukloniTrenera(@PathVariable Long id)
    {
        this.trenerService.delete(id);
       repo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/dodajTreneraUFF/{idF}/{idT}")
    public ResponseEntity<Void> spojiTF(@PathVariable Long idF,@PathVariable Long idT)
    {
        FitnesCentar f=this.frepo.findById(idF).get();
       Trener t=this.trepo.findById(idT).get();
       t.setFF(f);
       trepo.save(t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
