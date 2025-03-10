package fr.miage.gestioncompte;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Compte {
    @Id
    @GeneratedValue
    private long id;

    private double solde;

    private int idClient;


    public Compte(){
    }

    public Compte(double solde, int idClient){
        this.solde = solde;
        this.idClient=idClient;
    }

    public long getId() {
        return this.id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getIdClient() {
        return idClient;
    }
}
