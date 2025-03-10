package com.example.gestionCompte;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.gestioncompte.Compte;
import fr.miage.gestioncompte.GestionCompteApplication;
import fr.miage.gestioncompte.RepoCompte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = GestionCompteApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class GestionCompteApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RepoCompte repoCompte;
    private Compte compte;

    @BeforeEach
    void setUp() {
        compte = new Compte(200,1);
        compte = repoCompte.save(compte);
    }


    @Test
    void testGet() throws Exception {
        // on teste que le client est bien créé
        MvcResult result = mvc.perform(get("/api/compte/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.solde", is(compte.getSolde())))
                .andExpect(jsonPath("$.idClient", is(compte.getIdClient()))).andReturn();
        System.out.println("Response: " + result.getResponse().getContentAsString());
    }

    @Test
    void testPostMoney() throws Exception {
        // on teste que le client est bien créé
        MvcResult result = mvc.perform(post("/api/compte/addMoney/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.solde", is(210.0)))
                .andExpect(jsonPath("$.idClient", is(compte.getIdClient()))).andReturn();
        System.out.println("Response: " + result.getResponse().getContentAsString());
    }

    @Test
    void testPostCompte() throws Exception {
        Compte compte1 = new Compte(0,2);
        ObjectMapper om = new ObjectMapper();
        String compteJson = om.writeValueAsString(compte1);
        // on teste que le client est bien créé
        MvcResult result = mvc.perform(post("/api/compte/addCompte")
                        .contentType("application/json")
                        .content(compteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.solde", is(0.0)))
                .andExpect(jsonPath("$.idClient", is(compte1.getIdClient()))).andReturn();
        System.out.println("Response: " + result.getResponse().getContentAsString());
    }

}
