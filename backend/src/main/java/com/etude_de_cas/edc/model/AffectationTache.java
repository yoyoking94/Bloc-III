package com.etude_de_cas.edc.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "affectation_tache")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AffectationTache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tache")
    private Tache tache;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
}
