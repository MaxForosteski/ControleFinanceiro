/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoFinanceira.infrastructure.dao;

import gestaoFinanceira.domain.user.User;
import gestaoFinanceira.domain.user.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everto_Clewito_Riber
 */

@ApplicationScoped
public class UserDAO implements UserRepository{
    
    @Inject
    private EntityManager em;
    
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());
    
    @Override
    @Transactional
    public void createUser(User user){
        try{
            user.setIsActive(true);
            user.setCreatedOn(Timestamp.from(Instant.now()));
            em.persist(user);
        } catch(PersistenceException e){
            LOGGER.log(Level.SEVERE,"Failed to create user: "+ user.getName(),e);
            throw new RuntimeException("Failed to create user, please try again.");
        }
    }
    
    @Override
    public User userById(Long id){
        try{
            return em.find(User.class, id);
        } catch (PersistenceException e){
            LOGGER.log(Level.SEVERE, "Failed to find user by Id");
            throw new RuntimeException("Failed to find user, please try again.");
        }
    }
    
    @Override
    public List<User> userListAll(){
        try{
            return em.createQuery("SELECT u FROM User u",User.class).getResultList();
        } catch(PersistenceException e){
            LOGGER.log(Level.SEVERE, "Failed to find users");
            throw new RuntimeException("Failed to find users, please try again.");
        }
    }
    
    @Override
    @Transactional
    public void updateUser(User user){
        try{
            em.merge(user);
        } catch(PersistenceException e){
            LOGGER.log(Level.SEVERE, "Failed to update user");
            throw new RuntimeException("Failed to update user, please try again.");
        }
    }
    
    @Override
    @Transactional
    public void logicalDeleteUser(Long id){
        try{
            User user = userById(id);
            user.setIsActive(false);
            em.merge(user);
        } catch(PersistenceException e){
            LOGGER.log(Level.SEVERE, "Failed to update user");
            throw new RuntimeException("Failed to update user, please try again.");
        }
    }
    
}
