package com.exampleAplikacija.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Ocena implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String ocena;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Clan clan;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trening trening;
    public Ocena (){}

    public Ocena(String ocena, Clan clan, Trening trening) {
        this.ocena = ocena;
        this.clan = clan;
        this.trening = trening;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }
}
