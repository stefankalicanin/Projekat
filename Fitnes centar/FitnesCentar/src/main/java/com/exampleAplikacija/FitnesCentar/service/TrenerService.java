package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerService {
    private final TrenerRepository trenerRepository;
    @Autowired
    public TrenerService(TrenerRepository trenerRepository) {
        this.trenerRepository=trenerRepository;
    }
    public void kreiraj(Trener trener)  {

        trenerRepository.save(trener);
    }
    public List<Trener> sviTreneri() {
        List<Trener> treneri = this.trenerRepository.findAll();
        return treneri;
    }
   public Trener getId(long id)
   {
       return trenerRepository.findById(id).get();
   }
}
