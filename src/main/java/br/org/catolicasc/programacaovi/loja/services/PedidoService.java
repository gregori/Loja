/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.services;

import br.org.catolicasc.programacaovi.loja.dao.PedidoDAO;
import br.org.catolicasc.programacaovi.loja.entities.Pedido;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class PedidoService {
    private PedidoDAO dao;     
    private SimpleEntityManager simpleEntityManager;
     
    public PedidoService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new PedidoDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Pedido pedido){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(pedido);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
     
    public void update(Pedido pedido) {
        try {
            simpleEntityManager.beginTransaction();
            dao.update(pedido);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public void delete(Pedido pedido) {
        try {
            simpleEntityManager.beginTransaction();
            dao.delete(pedido);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public Pedido find(Long id) {
        return dao.getById(id);
    }
    
    public List<Pedido> findAll(){
        return dao.findAll();
    }
}
