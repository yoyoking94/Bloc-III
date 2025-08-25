package com.etude_de_cas.edc.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tache")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_echeance")
    private LocalDate dateEcheance;

    private String priorite;
    private String statut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "id_projet", nullable = false)
    private Projet projet;

    // Tâche assignée à plusieurs utilisateurs (N:N via AffectationTache)
    @OneToMany(mappedBy = "tache")
    private List<AffectationTache> affectations;

    // Historique de modification de cette tâche
    @OneToMany(mappedBy = "tache")
    private List<HistoriqueModification> historique;
}
