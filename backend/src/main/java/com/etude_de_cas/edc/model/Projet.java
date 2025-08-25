package com.etude_de_cas.edc.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projet")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @ManyToOne
    @JoinColumn(name = "cree_par", nullable = false)
    private Utilisateur createur;

    // Membres du projet (relation N:N via MembreProjet)
    @OneToMany(mappedBy = "projet")
    private List<MembreProjet> membres;

    // Liste des tâches du projet
    @OneToMany(mappedBy = "projet")
    private List<Tache> taches;
}
