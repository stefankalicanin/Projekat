package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.FitnesCentar;
import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.entity.Trening;
import com.exampleAplikacija.FitnesCentar.repository.ClanRepository;
import com.exampleAplikacija.FitnesCentar.repository.FitnesCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FitnesCentarService {
    private final FitnesCentarRepository fitnesCentarRepository;
    @Autowired
    public FitnesCentarService(FitnesCentarRepository fitnesCentarRepository) {
        this.fitnesCentarRepository=fitnesCentarRepository;
    }
    public FitnesCentar sacuvaj(FitnesCentar FF) throws Exception {
        if (FF.getId() != null) {
            throw new Exception("ID must be null!");
        }
       FitnesCentar noviFF=this.fitnesCentarRepository.save(FF);
        return noviFF;
    }
    public List<FitnesCentar> sviFF() {
        List<FitnesCentar> ff = this.fitnesCentarRepository.findAll();
        return ff;
    }
    public void obrisi(long id) {
        this.fitnesCentarRepository.deleteById(id);
    }
    public FitnesCentar getId(long id)
    {
        return fitnesCentarRepository.findById(id).get();
    }
    public void izmeni(FitnesCentar fitnesCentar)
    {

    }




}
