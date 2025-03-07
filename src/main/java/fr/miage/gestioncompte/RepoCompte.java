package fr.miage.gestioncompte;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCompte extends CrudRepository<Compte, Long> {
}
