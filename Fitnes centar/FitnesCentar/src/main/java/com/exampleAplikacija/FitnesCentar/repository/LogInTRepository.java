package com.exampleAplikacija.FitnesCentar.repository;


import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInTrenera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface LogInTRepository extends JpaRepository<LogInTrenera,Long> {
    @Query("SELECT k FROM LogInTrenera k WHERE k.korisnickoIme = ?1 and k.lozinka = ?2")
    LogInTrenera pronadjiKorisnika(String korisnickoIme, String lozinka);
}
