package com.exampleAplikacija.FitnesCentar.entity.DTO;

import java.io.Serializable;

public class FCDTO implements Serializable {
    private Integer kapacitet;
    private String oznaka;
    private long ff_id;

    public FCDTO(Integer kapacitet, String oznaka, long ff_id) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.ff_id = ff_id;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public long getFf_id() {
        return ff_id;
    }

    public void setFf_id(long ff_id) {
        this.ff_id = ff_id;
    }
}
