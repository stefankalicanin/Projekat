package com.exampleAplikacija.FitnesCentar.repository;

import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LogInRepository extends JpaRepository<LogInKorisnika,Long> {
    @Query("SELECT k FROM LogInKorisnika k WHERE k.korisnickoIme = ?1 and k.lozinka = ?2")
    LogInKorisnika pronadjiKorisnika(String korisnickoIme, String lozinka);
}
