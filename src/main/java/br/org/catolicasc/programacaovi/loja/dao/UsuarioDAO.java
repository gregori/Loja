/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.dao;

import br.org.catolicasc.programacaovi.loja.entities.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rodrigo
 */
public class UsuarioDAO extends GenericDAO<Long, Usuario> {
    public UsuarioDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Usuario findByToken(String token) {
        List<Usuario> l = entityManager
                .createQuery("SELECT u FROM Usuario u WHERE u.token = :token")
                .setParameter("token", token)
                .getResultList();
        if (l.size() > 0) return l.get(0);
        return null;
    }
}
