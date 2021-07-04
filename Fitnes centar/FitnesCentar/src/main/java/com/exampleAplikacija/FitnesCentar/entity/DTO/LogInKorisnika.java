package com.exampleAplikacija.FitnesCentar.entity.DTO;

import com.exampleAplikacija.FitnesCentar.controller.LogInController;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class LogInKorisnika implements Serializable
{ @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String korisnickoIme;
    @Column
    private String lozinka;
    @Column
    private String uloga;
    @Column
    private String aktivan;
  public LogInKorisnika(){}


    public LogInKorisnika(String korisnickoIme, String lozinka, String uloga, String aktivan) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
        this.aktivan = aktivan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public String getAktivan() {
        return aktivan;
    }

    public void setAktivan(String aktivan) {
        this.aktivan = aktivan;
    }
}
