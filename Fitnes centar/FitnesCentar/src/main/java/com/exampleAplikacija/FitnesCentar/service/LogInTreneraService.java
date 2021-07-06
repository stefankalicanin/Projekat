package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInTrenera;
import com.exampleAplikacija.FitnesCentar.repository.LogInRepository;
import com.exampleAplikacija.FitnesCentar.repository.LogInTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInTreneraService {
    private final LogInTRepository trepo;
    @Autowired
    public LogInTreneraService(LogInTRepository trepo) {
        this.trepo=trepo;
    }
    public LogInTrenera potvrdaPrijave(String korisnickoIme, String lozinka)
    {
        LogInTrenera korisnik= trepo.pronadjiKorisnika(korisnickoIme,lozinka);
        if(korisnik==null)
        {
            new Exception("Korisnik ne postoji");
        }
        return korisnik;
    }
}
