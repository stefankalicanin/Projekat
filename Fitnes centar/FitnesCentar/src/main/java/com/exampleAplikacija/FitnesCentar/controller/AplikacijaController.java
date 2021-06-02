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



}
