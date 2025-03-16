/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoFinanceira.application.user;

import gestaoFinanceira.domain.user.UserRepository;
import jakarta.inject.Inject;

/**
 *
 * @author Everto_Clewito_Riber
 */
public class LogicalDeleteUserWrapper {
    
    private final UserRepository userRepository;
    
    @Inject
    public LogicalDeleteUserWrapper(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public void logicalDeleteUserWrapper(Long id){
        userRepository.logicalDeleteUser(id);
    }
}
