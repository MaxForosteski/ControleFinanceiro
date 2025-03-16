/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoFinanceira.domain.user;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Everto_Clewito_Riber
 */
public interface UserRepository {
    void createUser(User user);
    User userById(Long id);
    List<User> userListAll();
    void updateUser(User user);
    void logicalDeleteUser(Long id);
}
