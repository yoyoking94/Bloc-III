package com.etude_de_cas.edc.repository;

import com.etude_de_cas.edc.model.AffectationTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationTacheRepository extends JpaRepository<AffectationTache, Long> {
}
