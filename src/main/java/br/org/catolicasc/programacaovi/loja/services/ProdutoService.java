/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.services;

import br.org.catolicasc.programacaovi.loja.dao.ProdutoDAO;
import br.org.catolicasc.programacaovi.loja.entities.Produto;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class ProdutoService {
    private ProdutoDAO dao;     
    private SimpleEntityManager simpleEntityManager;
     
    public ProdutoService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new ProdutoDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Produto produto){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(produto);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
     
    public void update(Produto produto) {
        try {
            simpleEntityManager.beginTransaction();
            dao.update(produto);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public void delete(Produto produto) {
        try {
            simpleEntityManager.beginTransaction();
            dao.delete(produto);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public Produto find(Long id) {
        return dao.getById(id);
    }
    
    public List<Produto> findAll(){
        return dao.findAll();
    }
}
