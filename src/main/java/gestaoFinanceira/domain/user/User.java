/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoFinanceira.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;


/**
 *
 * @author Everto_Clewito_Riber
 */

@Entity
@Table(name = "User")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name",nullable = false,length = 120)
    private String name;
    
    @Column(name = "username", nullable = false, length = 120)
    private String username;
    
    @Column(name = "email", nullable = true, length = 120)
    private String email;
    
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "lastLogin",nullable = true)
    private Timestamp lastLogin;
    
    @Column(name = "IsActive",nullable = false)
    private boolean IsActive;
    
    @Column(name = "createdOn",nullable = true)
    private Timestamp createdOn;
    
    @Column(name = "updateOn",nullable = true)
    private Timestamp updatedOn;

    public User(Long id, String name, String username, String email, String password, Timestamp lastLogin, Timestamp createdOn, Timestamp updatedOn,boolean IsActive) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastLogin = lastLogin;
        this.IsActive = IsActive;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }
    
    
}
