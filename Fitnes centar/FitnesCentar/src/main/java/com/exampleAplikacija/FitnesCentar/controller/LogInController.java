package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.Clan;
import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInTrenera;
import com.exampleAplikacija.FitnesCentar.repository.AdministratorRepository;
import com.exampleAplikacija.FitnesCentar.repository.LogInTRepository;
import com.exampleAplikacija.FitnesCentar.service.LogInService;
import com.exampleAplikacija.FitnesCentar.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LogInController {
    private final LogInService logInService;
    @Autowired
    public LogInController(LogInService logInService) {
        this.logInService=logInService;
    }
    @Autowired
    public LogInTRepository trepo;

    @GetMapping("/login_korisnika.html")
    public String getLogIn(Model model)
    {
        model.addAttribute("korisnik",new LogInKorisnika());
        return "login_korisnika";
    }
    @PostMapping("/prijava_clana")
    public String getPrijava(@Param("korisnickoIme") String korisnickoIme,@Param("lozinka") String lozinka,Model model)
    {
        LogInKorisnika korisnik=logInService.potvrdaPrijave(korisnickoIme,lozinka);
        LogInTrenera trener=trepo.pronadjiKorisnika(korisnickoIme,lozinka);
        if(korisnickoIme.equals("Stefan13")&&lozinka.equals("lozinka13"))
        {
            return "Admin";
        }

       else if(korisnik==null&&trener==null)
       {
           return "redirect:/login_korisnika.html";
       }

        else if(korisnik!=null)
        {
            model.addAttribute("id",korisnik.getId());
            model.addAttribute("korisnickoIme",korisnik.getKorisnickoIme());
            return "ulogovanClan";
        }
       else
        {
            model.addAttribute("id",trener.getId());
            model.addAttribute("korisnickoIme",trener.getKorisnickoIme());
            return "ulogovanTrener";
        }


    }
}
