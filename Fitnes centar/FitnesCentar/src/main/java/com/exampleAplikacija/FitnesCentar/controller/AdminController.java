package com.exampleAplikacija.FitnesCentar.controller;

import com.exampleAplikacija.FitnesCentar.entity.*;
import com.exampleAplikacija.FitnesCentar.entity.DTO.FCDTO;
import com.exampleAplikacija.FitnesCentar.entity.DTO.LogInKorisnika;
import com.exampleAplikacija.FitnesCentar.entity.DTO.TrenerDTO;
import com.exampleAplikacija.FitnesCentar.repository.*;
import com.exampleAplikacija.FitnesCentar.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    private final FitnesCentarService fitnesCentarService;
    @Autowired
    public LogInRepository repo;
    @Autowired
    public SalaRepository srepo;
    @Autowired
    public TrenerDtoRepository trenerDtoRepository;
    @Autowired
    public TrenerRepository trepo;
    @Autowired
    public FitnesCentarRepository frepo;
    @Autowired
    public AdminController(FitnesCentarService fitnesCentarService) {
        this.fitnesCentarService=fitnesCentarService;
    }
    @PostMapping(value="/dodajFitnesCentar",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentar> dodajFitnesCentar(@RequestBody FitnesCentar fitnesCentar) throws Exception {
        FitnesCentar noviFF = fitnesCentarService.sacuvaj(fitnesCentar);
        return new ResponseEntity<>(fitnesCentar, HttpStatus.CREATED);
    }
    @PostMapping(value="/dodajSalu",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sala> dodajSalu(@RequestBody FCDTO ff) throws Exception {
       FitnesCentar fitnes=this.fitnesCentarService.getId(ff.getFf_id());
       Sala sala=new Sala(ff.getKapacitet(),ff.getOznaka(),fitnes);

       srepo.save(sala);
        return new ResponseEntity<>(sala, HttpStatus.CREATED);
    }
    @GetMapping("/odobravanje_zahteva.html")
    public String getRegistracijaClana(Model model)
    {
        model.addAttribute("trener",new Trener());

        return "odobravanje_zahteva";
    }
    @PostMapping("/automatska_registracija")
    public String automatskaRegistracijaTrenera(Trener trener)
    {
        String prezime=trener.getPrezime();
        String ime=trener.getKorisnicko_ime();
        String lozinka=trener.getLozinka();
        String uloga="trener";
        LogInKorisnika korisnik=new LogInKorisnika(ime,lozinka,"trener","da");
        trener.setAktivan("da");
        trepo.save(trener);


        return "redirect:/Admin.html";
    }
    @GetMapping(value="/sviFF",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentar>> getFF() {

        List<FitnesCentar> listaFF = this.fitnesCentarService.sviFF();
        return new ResponseEntity<>(listaFF, HttpStatus.OK);
    }
    @PostMapping("/obrisi/{id}")
    public ResponseEntity<Void> obrisiFF(@PathVariable Long id)
    {
        this.fitnesCentarService.obrisi(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/izmeniff/{id}")
    public ResponseEntity<Void> izmeniFF(@RequestBody FitnesCentar fitnesCentar,@PathVariable Long id)
    {
        FitnesCentar fitnesCentar1= fitnesCentarService.getId(id);
        fitnesCentar1.setNaziv(fitnesCentar.getNaziv());
        fitnesCentar1.setEmail(fitnesCentar.getEmail());
        fitnesCentar1.setAdresa(fitnesCentar.getAdresa());
        fitnesCentar1.setBroj_telefona_centrale(fitnesCentar.getBroj_telefona_centrale());
      frepo.save(fitnesCentar1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/izmeniSalu/{id}")
    public ResponseEntity<Void> izmeniSalu(@RequestBody Sala sala,@PathVariable Long id)
    {
        Sala sala1=srepo.getOne(id);
      sala1.setKapacitet(sala.getKapacitet());
      sala1.setOznaka_sale(sala.getOznaka_sale());
        srepo.save(sala1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/obrisiSalu/{id}")
    public ResponseEntity<Void> obrisiSalu(@PathVariable Long id)
    {
       this.srepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
