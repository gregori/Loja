/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
/**
 * @author Rodrigo
 * 
 * This class encapsulates some work of EntityManager and EntityManagerFactory, 
 * doing only the essential
 * 
 */
public class SimpleEntityManager {
    private EntityManager entityManager;
    private EntityManagerFactory factory;
     
    public SimpleEntityManager(EntityManagerFactory factory) {
        this.factory = factory;
        this.entityManager = factory.createEntityManager();
    }
     
    public SimpleEntityManager(String persistenceUnitName){
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.entityManager = factory.createEntityManager();
    }
 
    public void beginTransaction(){
        entityManager.getTransaction().begin();
    }
     
    public void commit(){
        entityManager.getTransaction().commit();
    }
     
    public void close(){
        entityManager.close();
        factory.close();
    }
     
    public void rollBack(){
        entityManager.getTransaction().rollback();
    }
     
    public EntityManager getEntityManager(){
        return entityManager;
    }
}
