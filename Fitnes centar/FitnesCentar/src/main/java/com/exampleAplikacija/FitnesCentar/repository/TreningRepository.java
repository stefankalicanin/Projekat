package com.exampleAplikacija.FitnesCentar.repository;

import com.exampleAplikacija.FitnesCentar.entity.Trening;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening,Long> {
    @Query("SELECT t FROM Trening t WHERE (?1=null or t.naziv=?1) AND (?2=null or t.opis=?2) AND (?3=null or t.tip_treninga=?3) AND (?4=null or t.trajanje=?4)")
    public List<Trening> pretraziPoVise(String kljucnaRec1,String kljucnaRec2,String kljucnaRec3,String kljucnaRec4);


}
