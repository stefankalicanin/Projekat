package com.exampleAplikacija.FitnesCentar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FitnesCentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naziv;
    @Column
    private String adresa;
    @Column
    private String broj_telefona_centrale;
    @Column
    private String email;
public FitnesCentar(){}
    public FitnesCentar(String naziv, String adresa, String broj_telefona_centrale, String email) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.broj_telefona_centrale = broj_telefona_centrale;
        this.email = email;
    }

    public FitnesCentar(String naziv, String adresa, String broj_telefona_centrale, String email, Set<Sala> sale) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.broj_telefona_centrale = broj_telefona_centrale;
        this.email = email;
        this.sale = sale;
    }

    @OneToMany(mappedBy = "FF", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trener> treneri=new HashSet<>();
    @OneToMany(mappedBy = "FF", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Sala> sale=new HashSet<>();
    @OneToMany(mappedBy = "FF", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Termin> raspored_odrzavanja_treninga=new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBroj_telefona_centrale() {
        return broj_telefona_centrale;
    }

    public void setBroj_telefona_centrale(String broj_telefona_centrale) {
        this.broj_telefona_centrale = broj_telefona_centrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(Set<Trener> treneri) {
        this.treneri = treneri;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<Termin> getRaspored_odrzavanja_treninga() {
        return raspored_odrzavanja_treninga;
    }

    public void setRaspored_odrzavanja_treninga(Set<Termin> raspored_odrzavanja_treninga) {
        this.raspored_odrzavanja_treninga = raspored_odrzavanja_treninga;
    }
}
