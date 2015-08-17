/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.services;

import br.org.catolicasc.programacaovi.loja.dao.ItemDAO;
import br.org.catolicasc.programacaovi.loja.entities.Item;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class ItemService {
    private ItemDAO dao;     
    private SimpleEntityManager simpleEntityManager;
     
    public ItemService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new ItemDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Item item){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(item);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
     
    public void update(Item item) {
        try {
            simpleEntityManager.beginTransaction();
            dao.update(item);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public void delete(Item item) {
        try {
            simpleEntityManager.beginTransaction();
            dao.delete(item);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public Item find(Long id) {
        return dao.getById(id);
    }
    
    public List<Item> findAll(){
        return dao.findAll();
    }
}
