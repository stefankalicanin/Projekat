package com.exampleAplikacija.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clan  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private  String korisnicko_ime;
    @Column
    private  String lozinka;
    @Column
    private String ime;
    @Column
    private String prezime;
    @Column
    private String kontakt_telefon;
    @Column
    private String email;
    @Column
    private String datum_rodjenja;
    @Column
    private Uloga uloga=Uloga.Clan_fitness_centra;
    @Column
    private String aktivan="ne";
    @ManyToMany(mappedBy = "odradjeni_treninzi")
    private Set<Trening> lista_odradjenih_treninga=new HashSet<>();
    @ManyToMany(mappedBy = "prijavljeni_treninzi")
    private Set<Trening> lista_prijavljenih_treninga=new HashSet<>();
    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ocena> ocena=new HashSet<>();

public Clan(){}

    public Clan(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, String email, String datum_rodjenja, Uloga uloga, String aktivan, Set<Trening> lista_odradjenih_treninga, Set<Trening> lista_prijavljenih_treninga, Set<Ocena> ocena) {
        this.id = id;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt_telefon = kontakt_telefon;
        this.email = email;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga = uloga;
        this.aktivan = aktivan;
        this.lista_odradjenih_treninga = lista_odradjenih_treninga;
        this.lista_prijavljenih_treninga = lista_prijavljenih_treninga;
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public String getKontakt_telefon() {
        return kontakt_telefon;
    }

    public void setKontakt_telefon(String kontakt_telefon) {
        this.kontakt_telefon = kontakt_telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(String datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public String getAktivan() {
        return aktivan;
    }

    public void setAktivan(String aktivan) {
        this.aktivan = aktivan;
    }

    public Set<Trening> getLista_odradjenih_treninga() {
        return lista_odradjenih_treninga;
    }

    public void setLista_odradjenih_treninga(Set<Trening> lista_odradjenih_treninga) {
        this.lista_odradjenih_treninga = lista_odradjenih_treninga;
    }

    public Set<Trening> getLista_prijavljenih_treninga() {
        return lista_prijavljenih_treninga;
    }

    public void setLista_prijavljenih_treninga(Set<Trening> lista_prijavljenih_treninga) {
        this.lista_prijavljenih_treninga = lista_prijavljenih_treninga;
    }

    public Set<Ocena> getOcena() {
        return ocena;
    }

    public void setOcena(Set<Ocena> ocena) {
        this.ocena = ocena;
    }
}
