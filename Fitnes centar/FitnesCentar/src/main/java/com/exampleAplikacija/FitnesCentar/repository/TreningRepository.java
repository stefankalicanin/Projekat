package com.exampleAplikacija.FitnesCentar.repository;

import com.exampleAplikacija.FitnesCentar.entity.Trening;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening,Long> {
    @Query("SELECT t FROM Trening t WHERE t.naziv=?1")
            public List<Trening> pretraziPoNazivu(String kljucnaRec);
    @Query("SELECT t FROM Trening t WHERE t.opis=?1")
    public List<Trening> pretraziPoOpisu(String kljucnaRec);
    @Query("SELECT t FROM Trening t WHERE t.tip_treninga=?1")
    public List<Trening> pretraziPoTipuTreninga(String kljucnaRec);
    @Query("SELECT t FROM Trening t WHERE t.trajanje=?1")
    public List<Trening> pretraziPoTrajanju(String kljucnaRec);
    @Query("SELECT t FROM Trening t WHERE t.cena=?1")
    public List<Trening> pretraziPoCeni(String kljucnaRec);
    @Query("SELECT t FROM Trening t WHERE t.naziv=?1 and t.opis=?2 and t.tip_treninga=?3 and t.trajanje=?4 and t.cena=?5 ")
    public List<Trening> pretraziPoVise(String kljucnaRec1,String kljucnaRec2,String kljucnaRec3,String kljucnaRec4,String kljucnaRec5);


}
