package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.Clan;

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
    public String procesRegistracijeClana(HttpServletRequest request,Clan clan)
    {
        clan.setAktivan("da");
            clanService.kreiraj(clan);

            return "index";
    }
}
