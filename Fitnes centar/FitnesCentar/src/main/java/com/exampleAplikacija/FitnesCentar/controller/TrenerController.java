package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.Trener;
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
    @GetMapping("/sviTreneri")
    public String viewHomePage(Model model) {
        List<Trener> listaTrenera = trenerService.sviTreneri();
        model.addAttribute("listaTrenera", listaTrenera);

        return "odobravanje_zahteva";
    }
    @RequestMapping("/izmeni/{id}")
    public ModelAndView potvrdaTrenera(@PathVariable(name="id")int id) {
        ModelAndView mav=new ModelAndView("odobravanje_zahteva");
       Trener trener=trenerService.getId(id);
       trener.setAktivan("da");
       trenerService.kreiraj(trener);
       mav.addObject("trener",trener);
   return mav;
    }


}
