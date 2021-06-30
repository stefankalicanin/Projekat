package com.exampleAplikacija.FitnesCentar.service;

import com.exampleAplikacija.FitnesCentar.entity.Clan;
import com.exampleAplikacija.FitnesCentar.entity.DTO.TrenerDTO;
import com.exampleAplikacija.FitnesCentar.entity.Trener;
import com.exampleAplikacija.FitnesCentar.repository.ClanRepository;
import com.exampleAplikacija.FitnesCentar.repository.TrenerDtoRepository;
import com.exampleAplikacija.FitnesCentar.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerDtoService {
    private final TrenerDtoRepository trenerDto;
    @Autowired
    public TrenerDtoService(TrenerDtoRepository trenerDto) {
        this.trenerDto=trenerDto;
    }
    public void kreiraj(TrenerDTO tD)  {

       trenerDto.save(tD);
    }
}
