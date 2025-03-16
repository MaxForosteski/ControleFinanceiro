/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoFinanceira.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Everto_Clewito_Riber
 */

@ApplicationScoped
public class CDIConfig {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

    @Produces
    public EntityManager produceEntityManager(){
        return emf.createEntityManager();
    }
}
