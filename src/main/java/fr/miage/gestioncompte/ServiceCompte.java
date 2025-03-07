package fr.miage.gestioncompte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCompte {

    @Autowired
    private RepoCompte repoCompte;

    public void createCompte(Compte compte) throws Exception {
        Optional<Compte> compteOptional = repoCompte.findById(compte.getId());
        if(compteOptional.isEmpty()){
            throw new Exception("Compte doesn't exist");
        }
        repoCompte.save(compte);
    }

    public Compte getCompteById(long id) throws Exception {
        Optional<Compte> compteOptional = repoCompte.findById(id);
        if(compteOptional.isEmpty()){
            throw new Exception("Compte doesn't exist");
        }
        return compteOptional.get();
    }

    public void addMoney(double argent, long id) throws Exception {
        Optional<Compte> compteOptional = repoCompte.findById(id);
        if(compteOptional.isEmpty()){
            throw new Exception("Compte doesn't exist");
        }
        double solde = compteOptional.get().getSolde();
        compteOptional.get().setSolde(solde + argent);
        repoCompte.save(compteOptional.get());
    }
}
