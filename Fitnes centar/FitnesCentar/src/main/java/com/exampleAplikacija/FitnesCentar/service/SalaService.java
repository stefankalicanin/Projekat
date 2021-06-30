package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.FitnesCentar;
import com.exampleAplikacija.FitnesCentar.entity.Sala;
import com.exampleAplikacija.FitnesCentar.entity.Trening;
import com.exampleAplikacija.FitnesCentar.repository.FitnesCentarRepository;
import com.exampleAplikacija.FitnesCentar.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
    private final SalaRepository salaRepository;
    @Autowired
    public SalaService(SalaRepository salaRepository) {
        this.salaRepository=salaRepository;
    }
    public void obrisi(long id) {
        this.salaRepository.deleteById(id);
    }
}
