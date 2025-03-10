package fr.miage.gestioncompte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@RestController
@RequestMapping("/api/compte")
public class ControllerCompte {

    @Autowired
    private ServiceCompte serviceCompte;

    @PostMapping("/addMoney/{id}")
    public Compte addMoney(@PathVariable ("id") long id) throws Exception {
        serviceCompte.addMoney(10,id);
        return serviceCompte.getCompteById(id);
    }

    @PostMapping("/addCompte")
    public Compte createCompte(@RequestBody Compte compte) throws Exception {
        serviceCompte.createCompte(compte);
        return serviceCompte.getCompteById(compte.getId());
    }

    @GetMapping("/{id}")
    public Compte getCompteById(@PathVariable ("id") long id) throws Exception {
        return serviceCompte.getCompteById(id);
    }

}
