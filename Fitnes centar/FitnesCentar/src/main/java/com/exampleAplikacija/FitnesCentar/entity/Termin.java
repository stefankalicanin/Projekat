package com.exampleAplikacija.FitnesCentar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Termin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String raspored_termina;

    @Column
    private Integer broj_prijavljenih_clanova;
    @Column
    private String cena;

    @ManyToMany(mappedBy = "termini")
    @JsonIgnore
    private Set<Sala> sale=new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Trening T;

    public Termin(){}
    public Termin( String raspored_termina, Integer broj_prijavljenih_clanova, String cena, Trening t) {
        this.raspored_termina = raspored_termina;
        this.broj_prijavljenih_clanova = broj_prijavljenih_clanova;
        this.cena = cena;
        T = t;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaspored_termina() {
        return raspored_termina;
    }

    public void setRaspored_termina(String raspored_termina) {
        this.raspored_termina = raspored_termina;
    }



    public Integer getBroj_prijavljenih_clanova() {
        return broj_prijavljenih_clanova;
    }

    public void setBroj_prijavljenih_clanova(Integer broj_prijavljenih_clanova) {
        this.broj_prijavljenih_clanova = broj_prijavljenih_clanova;
    }



    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Trening getT() {
        return T;
    }

    public void setT(Trening t) {
        T = t;
    }
}
