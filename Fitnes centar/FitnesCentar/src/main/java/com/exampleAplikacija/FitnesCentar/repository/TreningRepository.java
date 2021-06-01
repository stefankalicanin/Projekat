package com.exampleAplikacija.FitnesCentar.repository;

import com.exampleAplikacija.FitnesCentar.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening,Long> {

}
