package com.etude_de_cas.edc.service;

import com.etude_de_cas.edc.model.Utilisateur;
import com.etude_de_cas.edc.repository.UtilisateurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class UtilisateurServiceTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurService utilisateurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void creerUtilisateur_devraitEnregistrerUtilisateur() {
        Utilisateur u = new Utilisateur();
        u.setNomUtilisateur("Alice");
        u.setEmail("alice@mail.com");
        u.setMotDePasse("pass123");

        when(utilisateurRepository.save(any(Utilisateur.class))).thenReturn(u);

        Utilisateur saved = utilisateurService.creerUtilisateur(u);

        assertNotNull(saved);
        assertEquals("Alice", saved.getNomUtilisateur());
        verify(utilisateurRepository, times(1)).save(u);
    }

    @Test
    void getUtilisateurParEmail_devraitRetournerResultat() {
        Utilisateur u = new Utilisateur();
        u.setEmail("bob@mail.com");

        when(utilisateurRepository.findByEmail("bob@mail.com"))
                .thenReturn(Optional.of(u));

        Optional<Utilisateur> result = utilisateurService.getUtilisateurParEmail("bob@mail.com");

        assertTrue(result.isPresent());
        assertEquals("bob@mail.com", result.get().getEmail());
    }
}
