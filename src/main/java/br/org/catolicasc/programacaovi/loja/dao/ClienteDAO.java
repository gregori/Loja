/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.dao;

import br.org.catolicasc.programacaovi.loja.entities.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author rodrigo
 */
public class ClienteDAO extends GenericDAO<Long, Cliente> {
    public ClienteDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
