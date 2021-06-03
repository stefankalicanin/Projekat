package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.entity.Trening;
import com.exampleAplikacija.FitnesCentar.repository.TrenerRepository;
import com.exampleAplikacija.FitnesCentar.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningService {
    private final TreningRepository treningRepository;
    @Autowired
    public TreningService(TreningRepository treningRepository) {
        this.treningRepository=treningRepository;
    }
    public List<Trening> pretragaTreningaPoNazivu(String kljucnaRec) {
        if (kljucnaRec != null) {
            return treningRepository.pretraziPoNazivu(kljucnaRec);
        }
        return treningRepository.findAll();
    }
    public List<Trening> pretragaTreningaPoOpisu(String kljucnaRec) {
        if (kljucnaRec != null) {
            return treningRepository.pretraziPoOpisu(kljucnaRec);
        }
        return treningRepository.findAll();
    }
    public List<Trening> pretragaTreningaPoTipu(String kljucnaRec) {
        if (kljucnaRec != null) {
            return treningRepository.pretraziPoTipuTreninga(kljucnaRec);
        }
        return treningRepository.findAll();
    }
    public List<Trening> pretragaTreningaPoTrajanju(String kljucnaRec) {
        if (kljucnaRec != null) {
            return treningRepository.pretraziPoTrajanju(kljucnaRec);
        }
        return treningRepository.findAll();
    }
    public List<Trening> pretragaTreningaPoCeni(String kljucnaRec) {
        if (kljucnaRec != null) {
            return treningRepository.pretraziPoCeni(kljucnaRec);
        }
        return treningRepository.findAll();
    }
    }

