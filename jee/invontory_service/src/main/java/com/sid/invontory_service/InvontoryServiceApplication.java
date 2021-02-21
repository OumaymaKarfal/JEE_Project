package com.sid.invontory_service;

import com.sid.invontory_service.dao.ProduitRepository;
import com.sid.invontory_service.entities.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InvontoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvontoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(ProduitRepository produitRepository, RepositoryRestConfiguration configuration){
        return args -> {
            configuration.exposeIdsFor(Produit.class);
            produitRepository.save(new Produit(null,"Airpods Wireless Bluetooth Headphones","/images/airpods.jpg",124.2,5,4.5, 20));
            produitRepository.save(new Produit(null,"Amazon Echo Dot 3rd Generation","/images/alexa.jpg",124.2,4,4.5,20));
            produitRepository.save(new Produit(null,"Cannon EOS 80D DSLR Camera","/images/camera.jpg",124.2,3,4.5,20));
            produitRepository.save(new Produit(null,"Yellow Couch in Great Condition","/images/couch.jpg",124.2,3,4.5,20));
            produitRepository.save(new Produit(null,"Logitech G-Series Gaming Mouse","/images/mouse.jpg",124.2,3,4.5,20));
            produitRepository.save(new Produit(null,"iPhone 11 Pro 256GB Memory","/images/phone.jpg",124.2,3,4.5,20));
            produitRepository.save(new Produit(null,"Sony Playstation 4 Pro White Version","/images/playstation.jpg",124.2,3,4.5,20));
            
            produitRepository.findAll().forEach(
                    p-> System.out.println(p.toString())
            );
        };
    }
}
