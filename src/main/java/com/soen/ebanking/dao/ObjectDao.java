/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.dao;

import com.soen.ebanking.model.Client;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.beanutils.BeanUtils;

public class ObjectDao<T> {

    private static final String PERSISTENCE_UNIT_NAME = "ebankingPU";
    private EntityManagerFactory emf;
    //private EntityManager em;

    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public ObjectDao() {
        getEMF();
    }

    public EntityManagerFactory getEMF() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }

    public void addObject(Object entity) {
        EntityManager em = this.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /* Method to UPDATE */
    public void updateObject(Object entity, long id, Class<T> ClassName) {
        EntityManager em = this.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            this.t = (T) em.find(ClassName, id);
            Object orig = entity;
            Object dest = this.t;
            BeanUtils.copyProperties(dest, orig);
            entity = t;
            t = null;
            em.getTransaction().commit();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ObjectDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ObjectDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteObject(Object object, long id, Class<T> ClassName) {
        EntityManager em = this.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(ClassName, id);
            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public T getObjectById(long id, Class<T> ClassName) {
        EntityManager em = this.getEMF().createEntityManager();
        try {
            return em.find(ClassName, id);
        } finally {
            em.close();
        }
    }

    public List getAllObjects(Class<T> ClassName, String tableName) {
       EntityManager em = this.getEMF().createEntityManager();
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = qb.createQuery(ClassName);
        //Root<T> entities = query.from(ClassName);
        List<T> result = em.createQuery(query).getResultList(); 
  
    return  result;
    }

    public ArrayList getAllObjectsByCondition(String tableName, String whereString) {
        EntityManager em = this.getEMF().createEntityManager();
        ArrayList entities = null;
        try {
            entities = (ArrayList) em.createQuery("SELECT t FROM " + tableName + " t WHERE " + whereString).getResultList();

            return entities;
        } finally {
            em.close();
        }
    }

    public T getAnObjectsByCondition(String tableName, String whereString) {
        EntityManager em = this.getEMF().createEntityManager();
        try {

            T result = (T) em.createQuery("Select t FROM " + tableName + " t WHERE " + whereString).getSingleResult();
            return result;
        } finally {
            em.close();
        }
    }

}
