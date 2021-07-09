package com.exampleAplikacija.FitnesCentar.repository;

import com.exampleAplikacija.FitnesCentar.entity.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OcenaRepository extends JpaRepository<Ocena,Long> {
    @Query(value = "SELECT o FROM Ocena o")
    List<Ocena> ocene();
}
