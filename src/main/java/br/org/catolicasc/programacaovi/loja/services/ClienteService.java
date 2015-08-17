/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.services;

import br.org.catolicasc.programacaovi.loja.dao.ClienteDAO;
import br.org.catolicasc.programacaovi.loja.entities.Cliente;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class ClienteService {
    private ClienteDAO dao;     
    private SimpleEntityManager simpleEntityManager;
     
    public ClienteService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new ClienteDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Cliente cliente){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(cliente);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
     
    public void update(Cliente cliente) {
        try {
            simpleEntityManager.beginTransaction();
            dao.update(cliente);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public void delete(Cliente cliente) {
        try {
            simpleEntityManager.beginTransaction();
            dao.delete(cliente);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public Cliente find(Long id) {
        return dao.getById(id);
    }
    
    public List<Cliente> findAll(){
        return dao.findAll();
    }
}
