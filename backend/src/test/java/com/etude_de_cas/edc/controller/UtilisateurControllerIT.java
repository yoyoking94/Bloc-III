package com.etude_de_cas.edc.controller;

import com.etude_de_cas.edc.model.Utilisateur;
import com.etude_de_cas.edc.repository.UtilisateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UtilisateurControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    void POST_register_devraitCreerUtilisateur() throws Exception {
        String json = """
            {
                "nomUtilisateur": "Charlie",
                "email": "charlie@mail.com",
                "motDePasse": "pass123"
            }
        """;

        mockMvc.perform(post("/api/utilisateurs/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("charlie@mail.com"));
    }

    @Test
    void GET_utilisateurs_devraitRetournerListe() throws Exception {
        // Préparer un utilisateur en BDD
        Utilisateur u = new Utilisateur();
        u.setNomUtilisateur("TestUser");
        u.setEmail("test@mail.com");
        u.setMotDePasse("pass");
        utilisateurRepository.save(u);

        mockMvc.perform(get("/api/utilisateurs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").exists());
    }
}
