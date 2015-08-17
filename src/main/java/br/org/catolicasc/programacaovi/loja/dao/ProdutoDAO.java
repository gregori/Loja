/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.dao;

import br.org.catolicasc.programacaovi.loja.entities.Produto;
import javax.persistence.EntityManager;

/**
 *
 * @author rodrigo
 */
public class ProdutoDAO extends GenericDAO<Long, Produto> {
    public ProdutoDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
