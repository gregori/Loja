/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.services;

import br.org.catolicasc.programacaovi.loja.dao.UsuarioDAO;
import br.org.catolicasc.programacaovi.loja.entities.Usuario;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class UsuarioService {
    private final UsuarioDAO dao;     
    private final SimpleEntityManager simpleEntityManager;
     
    public UsuarioService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new UsuarioDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Usuario usuario){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(usuario);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
     
    public void update(Usuario usuario) {
        try {
            simpleEntityManager.beginTransaction();
            dao.update(usuario);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public void delete(Usuario usuario) {
        try {
            simpleEntityManager.beginTransaction();
            dao.delete(usuario);
            simpleEntityManager.commit();
        } catch(Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public Usuario find(Long id) {
        return dao.getById(id);
    }
    
    public List<Usuario> findAll(){
        return dao.findAll();
    }
    
    public Usuario findByToken(String token) {
        return dao.findByToken(token);
    }
}
