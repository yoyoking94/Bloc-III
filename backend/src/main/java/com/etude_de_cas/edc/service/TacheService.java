package com.etude_de_cas.edc.service;

import com.etude_de_cas.edc.model.Tache;
import com.etude_de_cas.edc.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    public Tache creerTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public List<Tache> getToutesTaches() {
        return tacheRepository.findAll();
    }

    public Optional<Tache> getTacheParId(Long id) {
        return tacheRepository.findById(id);
    }

    public Tache mettreAJourTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);
    }
}
