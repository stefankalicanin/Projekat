package com.exampleAplikacija.FitnesCentar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AplikacijaController {
    @RequestMapping(value="/index.html")
    public String getPocetnaStranica()
    {
        return "index";
    }
    @RequestMapping(value="/odobravanje_zahteva.html")
    public String getOdobravanjeZahteva()
    {
        return "odobravanje_zahteva";
    }
    @RequestMapping(value="/dodavanje_fitnes_centra.html")
    public String getDodavanjeFitnesCentra()
    {
        return "dodavanje_fitnes_centra";
    }
    @RequestMapping(value="/Admin.html")
    public String getAdminStranica()
    {
        return "Admin";
    }
    @RequestMapping(value="/pregled_treninga.html")
    public String getPregledTreninga()
    {
        return "pregled_treninga";
    }
    @RequestMapping(value="/pregled_ff_centra.html")
    public String getPregledFF()
    {
        return "pregled_ff_centra";
    }
    @RequestMapping(value="/pregled_sala.html")
    public String getPregledFF1()
    {
        return "pregled_sala";
    }
    @RequestMapping(value="/ulogovanTrener.html")
    public String getUlogovanTrener()
    {
        return "ulogovanTrener";
    }


}
