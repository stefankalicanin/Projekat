package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.Clan;

import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import com.exampleAplikacija.FitnesCentar.entity.Korisnik;
import com.exampleAplikacija.FitnesCentar.repository.KorisnikRepository;
import com.exampleAplikacija.FitnesCentar.repository.LogInRepository;
import com.exampleAplikacija.FitnesCentar.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistracijaController {
    private final ClanService clanService;
    @Autowired
    public LogInRepository repo;
    @Autowired
    public RegistracijaController(ClanService clanService) {
        this.clanService=clanService;
    }

    @GetMapping("/registracija_clana.html")
    public String getRegistracijaClana(Model model)
    {
        model.addAttribute("clan",new Clan());

        return "registracija_clana";
    }
    @PostMapping("/registracija_clana")
    public String procesRegistracijeClana(Clan clan)
    {
        String ime=clan.getKorisnicko_ime();
        String lozinka=clan.getLozinka();
        String uloga="clan";
        LogInKorisnika korisnik=new LogInKorisnika(ime,lozinka,"clan","da");
        korisnik.setUloga(uloga);
        repo.save(korisnik);
        clan.setAktivan("da");
            clanService.kreiraj(clan);
            return "redirect:/login_korisnika.html";
    }
}
