package com.exampleAplikacija.FitnesCentar.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column

    private String naziv;
    @Column

    private String opis;
    @Column

    private String tip_treninga;
    @Column

    private String trajanje;
    @Column
    private String cena;



    @ManyToMany
    @JoinTable(name = "trening_trener",
            joinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trener_id", referencedColumnName = "id"))
    private Set<Trener> lista_treninga=new HashSet<>();
    @ManyToMany
    @JoinTable(name = "odradjentrening_clan",
            joinColumns = @JoinColumn(name = "treningodradjen_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"))
    private Set<Clan> odradjeni_treninzi = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "prijavljentrening_clan",
            joinColumns = @JoinColumn(name = "treningprijavljen_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"))
    private Set<Clan> prijavljeni_treninzi = new HashSet<>();
    @OneToMany(mappedBy = "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ocena> ocenjen_trening=new HashSet<>();


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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTip_treninga() {
        return tip_treninga;
    }

    public void setTip_treninga(String tip_treninga) {
        this.tip_treninga = tip_treninga;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public Set<Trener> getLista_treninga() {
        return lista_treninga;
    }

    public void setLista_treninga(Set<Trener> lista_treninga) {
        this.lista_treninga = lista_treninga;
    }

    public Set<Clan> getOdradjeni_treninzi() {
        return odradjeni_treninzi;
    }

    public void setOdradjeni_treninzi(Set<Clan> odradjeni_treninzi) {
        this.odradjeni_treninzi = odradjeni_treninzi;
    }

    public Set<Clan> getPrijavljeni_treninzi() {
        return prijavljeni_treninzi;
    }

    public void setPrijavljeni_treninzi(Set<Clan> prijavljeni_treninzi) {
        this.prijavljeni_treninzi = prijavljeni_treninzi;
    }

    public Set<Ocena> getOcenjen_trening() {
        return ocenjen_trening;
    }

    public void setOcenjen_trening(Set<Ocena> ocenjen_trening) {
        this.ocenjen_trening = ocenjen_trening;
    }
    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }
}
