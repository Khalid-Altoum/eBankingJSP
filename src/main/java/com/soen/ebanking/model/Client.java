/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Entity
public class Client extends User implements Serializable {

    private long age;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;
    
    
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

      
    @Override
    public void saveUser() {
        ObjectDao<Client> userDao = new ObjectDao<Client>();
        userDao.addObject(this);
    }

    @Override
    public void updateUser() {
        ObjectDao<Client> userDao = new ObjectDao<Client>();
        userDao.updateObject(this, this.getUserId(), Client.class);
    }

    @Override
    public void deleteUser() {
        ObjectDao<Client> userDao = new ObjectDao<Client>();
        userDao.deleteObject(this, this.getUserId(), Client.class);
    }

    public static Client getClientsById(long id) {
        ObjectDao<Client> dao = new ObjectDao<Client>();
        return dao.getObjectById(id, Client.class);

    }

    public static ArrayList<Client> getClients() {
        ObjectDao<Client> dao = new ObjectDao<Client>();
        return dao.getAllObjects(Client.class, "client");

    }

    public static Client getClientByUserName(String userName) {
        ObjectDao<Client> dao = new ObjectDao<Client>();
        EntityManager em = dao.getEMF().createEntityManager();
        
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Client> query = qb.createQuery(Client.class);
        Root<Client> employee = query.from(Client.class);
        query.where(qb.equal(employee.get("userName"), userName));
        List<Client> result = em.createQuery(query).getResultList();
        
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }

    }

    public static Client login(String userName, String password) {
        Client client = Client.getClientByUserName(userName);
        if (client == null) {
            return null;
        }

        if (client.getPassword().equals(password)) {
            return client;
        }
        return null;
    }

}
