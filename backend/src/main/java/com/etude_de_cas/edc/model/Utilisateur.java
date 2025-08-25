package com.etude_de_cas.edc.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomUtilisateur;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    // Un utilisateur peut être le créateur de plusieurs projets
    @OneToMany(mappedBy = "createur")
    private List<Projet> projetsCrees;

    // Notifications reçues
    @OneToMany(mappedBy = "utilisateur")
    private List<Notification> notifications;

    // Historique des modifs faites par cet utilisateur
    @OneToMany(mappedBy = "utilisateur")
    private List<HistoriqueModification> modifications;
}
