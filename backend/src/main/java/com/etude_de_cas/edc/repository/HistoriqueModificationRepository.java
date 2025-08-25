package com.etude_de_cas.edc.repository;

import com.etude_de_cas.edc.model.HistoriqueModification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueModificationRepository extends JpaRepository<HistoriqueModification, Long> {
}
