package com.etude_de_cas.edc.service;

import com.etude_de_cas.edc.model.Projet;
import com.etude_de_cas.edc.model.Utilisateur;
import com.etude_de_cas.edc.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    public Projet creerProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    public List<Projet> getTousProjets() {
        return projetRepository.findAll();
    }

    public Optional<Projet> getProjetParId(Long id) {
        return projetRepository.findById(id);
    }

    public void supprimerProjet(Long id) {
        projetRepository.deleteById(id);
    }
}
