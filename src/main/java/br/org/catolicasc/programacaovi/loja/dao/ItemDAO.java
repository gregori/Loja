/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.dao;

import br.org.catolicasc.programacaovi.loja.entities.Item;
import javax.persistence.EntityManager;

/**
 *
 * @author rodrigo.gregori
 */
public class ItemDAO extends GenericDAO<Long, Item> {
    public ItemDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
