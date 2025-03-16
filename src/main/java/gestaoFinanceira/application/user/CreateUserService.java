/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoFinanceira.application.user;

import gestaoFinanceira.domain.user.User;
import gestaoFinanceira.domain.user.UserRepository;
import jakarta.inject.Inject;

/**
 *
 * @author Everto_Clewito_Riber
 */
public class CreateUserService {
    
    private final UserRepository userRepository;
    
    @Inject
    public CreateUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public void createUserWrapper(User user){
        userRepository.createUser(user);
    }
}
