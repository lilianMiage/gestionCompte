package fr.miage.gestioncompte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionCompteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCompteApplication.class, args);
	}

}
