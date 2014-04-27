/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long userId;

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private boolean blocked;
    private int numberOfAttempts;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address userAddress;

    public  User(){
    blocked=false;
    numberOfAttempts=0;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public void saveUser() {
        ObjectDao<User> userDao = new ObjectDao<User>();
        userDao.addObject(this);
    }

    public void updateUser() {
        ObjectDao<User> userDao = new ObjectDao<User>();
        userDao.updateObject(this, this.getUserId(), User.class);
    }

    public void deleteUser() {
        ObjectDao<User> userDao = new ObjectDao<User>();
        userDao.deleteObject(this, this.getUserId(), User.class);
    }

    public static User getUserById(long id) {
        ObjectDao<User> dao = new ObjectDao<User>();
        return dao.getObjectById(id, User.class);
    }

    public static ArrayList<User> getUsers() {
        ObjectDao<User> dao = new ObjectDao<User>();
        return dao.getAllObjects(User.class, "Person");
    }
   
}
