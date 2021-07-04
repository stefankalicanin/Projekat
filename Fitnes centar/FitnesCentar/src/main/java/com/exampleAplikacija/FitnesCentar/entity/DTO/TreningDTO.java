package com.exampleAplikacija.FitnesCentar.entity.DTO;

import java.io.Serializable;

public class TreningDTO implements Serializable {
    private String raspored_termina;
    private Integer broj_prijavljenih_clanova;
    private String cena;
    private Long trening_id;

    public TreningDTO(String respored_termina, Integer broj_prijavljenih_clanova, String cena, Long trening_id) {
        this.raspored_termina = respored_termina;
        this.broj_prijavljenih_clanova = broj_prijavljenih_clanova;
        this.cena = cena;
        this.trening_id = trening_id;
    }

    public String getRaspored_termina() {
        return raspored_termina;
    }

    public void setRaspored_termina(String respored_termina) {
        this.raspored_termina = respored_termina;
    }

    public Integer getBroj_prijavljenih_clanova() {
        return broj_prijavljenih_clanova;
    }

    public void setBroj_prijavljenih_clanova(Integer broj_rpijavljenih_clanova) {
        this.broj_prijavljenih_clanova = broj_rpijavljenih_clanova;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Long getTrening_id() {
        return trening_id;
    }

    public void setTrening_id(Long trening_id) {
        this.trening_id = trening_id;
    }
}
