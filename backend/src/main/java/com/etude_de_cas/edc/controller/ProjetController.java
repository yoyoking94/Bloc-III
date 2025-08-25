package com.etude_de_cas.edc.controller;

import com.etude_de_cas.edc.model.Projet;
import com.etude_de_cas.edc.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projets")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    @PostMapping
    public Projet creerProjet(@RequestBody Projet projet) {
        return projetService.creerProjet(projet);
    }

    @GetMapping
    public List<Projet> getTousProjets() {
        return projetService.getTousProjets();
    }

    @GetMapping("/{id}")
    public Optional<Projet> getProjetParId(@PathVariable Long id) {
        return projetService.getProjetParId(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerProjet(@PathVariable Long id) {
        projetService.supprimerProjet(id);
    }
}
