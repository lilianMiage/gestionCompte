package fr.miage.gestioncompte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@Controller
@RequestMapping("/api/compte")
public class ControllerCompte {

    @Autowired
    private ServiceCompte serviceCompte;

    @PostMapping("/addMoney/{id}")
    public void addMoney(@PathVariable ("id") long id) throws Exception {
        serviceCompte.addMoney(10,id);
    }

    @PostMapping("/addCompte")
    public void createCompte(@RequestBody Compte compte) throws Exception {
        serviceCompte.createCompte(compte);
    }

    @GetMapping("{/id}")
    public Compte getCompteById(@PathVariable ("id") long id) throws Exception {
        return serviceCompte.getCompteById(id);
    }

}
