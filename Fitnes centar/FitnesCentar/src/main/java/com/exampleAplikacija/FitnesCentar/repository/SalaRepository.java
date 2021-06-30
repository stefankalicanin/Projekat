package com.exampleAplikacija.FitnesCentar.repository;

import com.exampleAplikacija.FitnesCentar.entity.Sala;
import com.exampleAplikacija.FitnesCentar.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala,Long> {

}
