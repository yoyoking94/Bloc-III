package com.etude_de_cas.edc.controller;

import com.etude_de_cas.edc.model.Tache;
import com.etude_de_cas.edc.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taches")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @PostMapping
    public Tache creerTache(@RequestBody Tache tache) {
        return tacheService.creerTache(tache);
    }

    @GetMapping
    public List<Tache> getToutesTaches() {
        return tacheService.getToutesTaches();
    }

    @GetMapping("/{id}")
    public Optional<Tache> getTacheParId(@PathVariable Long id) {
        return tacheService.getTacheParId(id);
    }

    @PutMapping("/{id}")
    public Tache mettreAJourTache(@PathVariable Long id, @RequestBody Tache tache) {
        tache.setId(id);
        return tacheService.mettreAJourTache(tache);
    }

    @DeleteMapping("/{id}")
    public void supprimerTache(@PathVariable Long id) {
        tacheService.supprimerTache(id);
    }
}
