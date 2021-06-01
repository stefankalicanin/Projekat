package com.exampleAplikacija.FitnesCentar.entity;


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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnesCentar FF;
    @ManyToMany
    @JoinTable(name = "sala_termin",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> termini=new HashSet<>();


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
}
