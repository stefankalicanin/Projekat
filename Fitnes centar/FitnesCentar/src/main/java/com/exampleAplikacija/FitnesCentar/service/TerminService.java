package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.FitnesCentar;
import com.exampleAplikacija.FitnesCentar.entity.Termin;
import com.exampleAplikacija.FitnesCentar.entity.Trening;
import com.exampleAplikacija.FitnesCentar.repository.TerminRepository;
import com.exampleAplikacija.FitnesCentar.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminService {
    private final TerminRepository terminRepository;
    @Autowired
    public TerminService(TerminRepository terminRepository) {
        this.terminRepository=terminRepository;
    }
    public Termin get(long id)
    {
        return terminRepository.findById(id).get();
    }
    public Termin sacuvaj(Termin t) throws Exception {
        if (t.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Termin t1=this.terminRepository.save(t);
        return t1;
    }
}
