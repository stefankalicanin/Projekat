package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.entity.Trening;
import com.exampleAplikacija.FitnesCentar.repository.TrenerRepository;
import com.exampleAplikacija.FitnesCentar.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningService {
    private final TreningRepository treningRepository;
    @Autowired
    public TreningService(TreningRepository treningRepository) {
        this.treningRepository=treningRepository;
    }
    public List<Trening> sviTreninzi() {
        List<Trening> treninzi = this.treningRepository.findAll();
        return treninzi;
    }

    public List<Trening> pretragaPoVise(String kljucnaRec1,String kljucnaRec2,String kljucnaRec3,String kljucnaRec4) {

            return treningRepository.pretraziPoVise(kljucnaRec1,kljucnaRec2,kljucnaRec3,kljucnaRec4);


    }

   public List<Trening> treninziSortiraniPoNazivu()
   {
       return treningRepository.findAll(Sort.by(Sort.Direction.ASC, "naziv"));
   }
    public List<Trening> treninziSortiraniPoOpisu()
    {
        return treningRepository.findAll(Sort.by(Sort.Direction.ASC, "opis"));
    }
    public List<Trening> treninziSortiraniPoTipu()
    {
        return treningRepository.findAll(Sort.by(Sort.Direction.ASC, "tip_treninga"));
    }
    public List<Trening> treninziSortiraniPoTrajanju()
    {
        return treningRepository.findAll(Sort.by(Sort.Direction.ASC, "trajanje"));
    }
    public Trening get(long id)
    {
        return treningRepository.findById(id).get();
    }
    }

