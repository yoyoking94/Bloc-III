package com.etude_de_cas.edc.repository;

import com.etude_de_cas.edc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNomRole(String nomRole);
}
