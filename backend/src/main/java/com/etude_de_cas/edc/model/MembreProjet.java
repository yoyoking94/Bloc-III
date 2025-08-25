package com.etude_de_cas.edc.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "membre_projet")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MembreProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_projet")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
}
