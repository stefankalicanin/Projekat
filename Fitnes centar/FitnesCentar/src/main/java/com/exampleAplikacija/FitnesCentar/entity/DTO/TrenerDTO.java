package com.exampleAplikacija.FitnesCentar.entity.DTO;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class TrenerDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String ime;
    @Column
    private String prezime;
public TrenerDTO(){}

    public TrenerDTO(Long id,String ime, String prezime) {
        this.id=id;
        this.ime = ime;
        this.prezime = prezime;
    }
    public TrenerDTO(String ime,String prezime)
    {
        this.ime=ime;
        this.prezime=prezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
