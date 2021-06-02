package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.repository.LogInRepository;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TrenerController {
    private final TrenerService trenerService;
    @Autowired
    public LogInRepository repo;

    @Autowired
    public TrenerController(TrenerService trenerService) {
        this.trenerService=trenerService;
    }
    @GetMapping("/registracija_trenera.html")
    public String getRegistracijaTrenera(Model model)
    {
        model.addAttribute("trener",new Trener());
        return "registracija_trenera";
    }
    @PostMapping("/registracija_trenera")
    public String procesRegistracijeTrenera(Trener trener)
    {

       trenerService.kreiraj(trener);
        return "index";
    }
    @GetMapping("/odobravanje_zahteva.html")
    public String viewHomePage(Model model) {
        List<Trener> listaTrenera = trenerService.sviTreneri();
        model.addAttribute("listaTrenera", listaTrenera);

        return "odobravanje_zahteva";
    }
    @RequestMapping("/izmeni/{id}")
    public String potvrdaTrenera(@PathVariable(name="id")int id,Model model) {
       Trener trener=trenerService.getId(id);
       trener.setAktivan("da");
        String ime=trener.getKorisnicko_ime();
        String lozinka=trener.getLozinka();
        String uloga="trener";
        String aktivan=trener.getAktivan();
        LogInKorisnika korisnik=new LogInKorisnika(ime,lozinka,aktivan);
        korisnik.setUloga(uloga);
        repo.save(korisnik);
       trenerService.kreiraj(trener);
        return "odobravanje_zahteva";
    }


}