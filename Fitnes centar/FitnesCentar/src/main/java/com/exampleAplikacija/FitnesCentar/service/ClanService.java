package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.Clan;
import com.exampleAplikacija.FitnesCentar.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanService {
    private final ClanRepository clanRepository;
    @Autowired
    public ClanService(ClanRepository clanRepository) {
        this.clanRepository=clanRepository;
    }
    public void kreiraj(Clan clan)  {

        clanRepository.save(clan);
    }
}
