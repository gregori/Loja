/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.dao;
import br.org.catolicasc.programacaovi.loja.entities.Pedido;
import javax.persistence.EntityManager;

/**
 *
 * @author rodrigo
 */
public class PedidoDAO extends GenericDAO<Long, Pedido> {
    public PedidoDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
