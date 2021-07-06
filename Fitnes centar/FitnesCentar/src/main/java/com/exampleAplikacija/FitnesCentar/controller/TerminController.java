package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.Clan;
import com.exampleAplikacija.FitnesCentar.entity.Sala;
import com.exampleAplikacija.FitnesCentar.entity.Termin;
import com.exampleAplikacija.FitnesCentar.entity.Trening;
import com.exampleAplikacija.FitnesCentar.repository.ClanRepository;
import com.exampleAplikacija.FitnesCentar.repository.TerminRepository;
import com.exampleAplikacija.FitnesCentar.repository.TreningRepository;
import com.exampleAplikacija.FitnesCentar.service.TerminService;
import com.exampleAplikacija.FitnesCentar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class TerminController {
    private final TerminService terminService;
    @Autowired
    public TerminController(TerminService terminService) {
        this.terminService=terminService;
    }
    @Autowired
    public TerminRepository terminr;
    @Autowired
    public TreningRepository treningr;
    @Autowired
    public ClanRepository clanr;
    @PostMapping(value = "/prijavaNaTermin/{id}/{id1}/{id2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> prijavaNaTermin(@PathVariable Long id,@PathVariable Long id1,@PathVariable Long id2) {
        Trening trening=this.treningr.getOne(id1);
        Clan clan=this.clanr.getOne(id2);
        trening.getPrijavljeni_treninzi().add(clan);
        clan.getLista_prijavljenih_treninga().add(trening);
        treningr.save(trening);
        Boolean uspesno=false;
        Termin termin=this.terminService.get(id);
        Integer broj_prijavljenih_clanova=termin.getBroj_prijavljenih_clanova();
        broj_prijavljenih_clanova++;
        Set<Sala> sale=termin.getSale();

        for(Sala nSala:sale)
        {
            if(nSala.getKapacitet()>=broj_prijavljenih_clanova)
            {
                uspesno=true;
                break;
            }
        }
        if(uspesno) {
            termin.setBroj_prijavljenih_clanova(broj_prijavljenih_clanova);
            this.terminr.save(termin);
        }
        return new ResponseEntity<>(uspesno,HttpStatus.OK);
    }
}
