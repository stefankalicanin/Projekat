package com.exampleAplikacija.FitnesCentar.entity;

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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnesCentar FF;
    @ManyToMany(mappedBy = "termini")
    private Set<Sala> sale=new HashSet<>();


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

    public FitnesCentar getFF() {
        return FF;
    }

    public void setFF(FitnesCentar FF) {
        this.FF = FF;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }
}
