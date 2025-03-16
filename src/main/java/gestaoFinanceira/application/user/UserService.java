/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoFinanceira.application.user;

import gestaoFinanceira.domain.user.User;
import gestaoFinanceira.domain.user.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author Everto_Clewito_Riber
 */
@ApplicationScoped
public class UserService {
    
    private final UserRepository userRepository;
    
    @Inject
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public User userByIdWrapper(Long id){
        return userRepository.userById(id);
    }
    
    public List userListAllWrapper(){
        return userRepository.userListAll();
    }
    
    
}
