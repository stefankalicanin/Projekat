package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.repository.LogInRepository;
import com.exampleAplikacija.FitnesCentar.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInService {
    private final LogInRepository repo;
    @Autowired
    public LogInService(LogInRepository repo) {
        this.repo=repo;
    }
    public LogInKorisnika potvrdaPrijave(String korisnickoIme,String lozinka)
    {
       LogInKorisnika korisnik= repo.pronadjiKorisnika(korisnickoIme,lozinka);
       return korisnik;
    }


}
