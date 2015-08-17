/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.resources;

import br.org.catolicasc.programacaovi.loja.entities.Pedido;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import br.org.catolicasc.programacaovi.loja.services.PedidoService;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author rodrigo
 */
@Path("/pedidos")
public class PedidoResource {
    // Permite injetar informação de URI na variável uriInfo
    @Context
    UriInfo uriInfo;
    
    private SimpleEntityManager simpleEntityManager;
    private PedidoService pedidoService;
    private static final String persistenceUnit = "LojaPU";
    
    public PedidoResource() {
        // Inicializamos o pedidoService
        // É preciso o entityManager, pois é parâmetro para o construtor do pedidoService
        this.simpleEntityManager = new SimpleEntityManager(persistenceUnit);
        this.pedidoService = new PedidoService(this.simpleEntityManager);
    }
    
    @GET
    @Produces("application/json")
    public Response getPedidos() {
        // Retorna diretamente o resultado de findAll()
        // Futuramente podemos criar os parâmetros de busca para paginação
        // Conforme a especificação
        List<Pedido> pedidos = pedidoService.findAll();
        GenericEntity<List<Pedido>> entity = new GenericEntity<List<Pedido>>(pedidos) {};
        
        return Response.ok(entity).build();
    }
    
    @POST
    @Consumes("application/json")
    public Response postPedidos(Pedido pedido) {
        //TODO: Tratamento de erro!
        pedidoService.save(pedido);
        // Cria a URI com o ID do pedido que acabamos de criar
        URI createdUri = uriInfo.getAbsolutePathBuilder().path(pedido.getId()
                .toString()).build();
                
        return Response.created(createdUri).build();
        
    }
    
    @PUT
    @Consumes("application/json")
    public Response atualizaPedidos(Pedido pedido) {
        //TODO: Tratamento de erro!
        pedidoService.update(pedido);
                
        return Response.ok(pedido).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getPedido(@PathParam("id") Long id) {
        Pedido pedido = pedidoService.find(id);
        return Response.ok(pedido).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response deletePedido(@PathParam("id") Long id) {
        Pedido pedido = pedidoService.find(id);
        pedidoService.delete(pedido);
        return Response.ok().build();
    }
}
