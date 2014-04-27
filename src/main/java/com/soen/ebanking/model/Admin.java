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
public class Admin extends User implements Serializable{
 @Override
    public void saveUser() {
        ObjectDao<Admin> userDao = new ObjectDao<Admin>();
        userDao.addObject(this);
    }

    @Override
    public void updateUser() {
        ObjectDao<Admin> userDao = new ObjectDao<Admin>();
        userDao.updateObject(this, this.getUserId(), Admin.class);
    }

    @Override
    public void deleteUser() {
        ObjectDao<Admin> userDao = new ObjectDao<Admin>();
        userDao.deleteObject(this, this.getUserId(), Admin.class);
    }

    public static Admin getAdminById(long id) {
        ObjectDao<Admin> dao = new ObjectDao<Admin>();
        return dao.getObjectById(id, Admin.class);

    }

    public static List<Admin> getClients() {
        ObjectDao<Admin> dao = new ObjectDao<Admin>();
        return dao.getAllObjects(Admin.class, "Admin");

    }

    public static Admin getAdminByUserName(String userName) {
        ObjectDao<Admin> dao = new ObjectDao<Admin>();
        EntityManager em = dao.getEMF().createEntityManager();
        
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Admin> query = qb.createQuery(Admin.class);
        Root<Admin> employee = query.from(Admin.class);
        query.where(qb.equal(employee.get("userName"), userName));
        List<Admin> result = em.createQuery(query).getResultList();
        
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }

    }

    public static Admin login(String userName, String password) {
        Admin admin = Admin.getAdminByUserName(userName);
        if (admin == null) {
            return null;
        }

        if (admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
   
}
