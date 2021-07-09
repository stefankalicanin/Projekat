package com.exampleAplikacija.FitnesCentar.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Integer kapacitet;
    @Column
    private String oznaka_sale;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private FitnesCentar FF;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "sala_termin",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Termin> termini=new HashSet<>();
public Sala(){}
    public Sala(Integer kapacitet, String oznaka_sale, FitnesCentar FF) {
        this.kapacitet = kapacitet;
        this.oznaka_sale = oznaka_sale;
        this.FF = FF;
    }

    public FitnesCentar getFF() {
        return FF;
    }

    public void setFF(FitnesCentar FF) {
        this.FF = FF;
    }

    public Set<Termin> getTermini() {
        return termini;
    }

    public void setTermini(Set<Termin> termini) {
        this.termini = termini;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka_sale() {
        return oznaka_sale;
    }

    public void setOznaka_sale(String oznaka_sale) {
        this.oznaka_sale = oznaka_sale;
    }

    public Set<Termin> getLista_treninga() {
        return termini;
    }

    public void setLista_treninga(Set<Termin> lista_treninga) {
        this.termini = lista_treninga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
