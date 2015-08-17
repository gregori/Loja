/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.resources;

import br.org.catolicasc.programacaovi.loja.entities.Produto;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import br.org.catolicasc.programacaovi.loja.services.ProdutoService;
import br.org.catolicasc.programacaovi.loja.services.ProdutoService;
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
@Path("/produtos")
public class ProdutoResource {
    // Permite injetar informação de URI na variável uriInfo
    @Context
    UriInfo uriInfo;
    
    private SimpleEntityManager simpleEntityManager;
    private ProdutoService produtoService;
    private static final String persistenceUnit = "LojaPU";
    
    public ProdutoResource() {
        // Inicializamos o produtoService
        // É preciso o entityManager, pois é parâmetro para o construtor do produtoService
        this.simpleEntityManager = new SimpleEntityManager(persistenceUnit);
        this.produtoService = new ProdutoService(this.simpleEntityManager);
    }
    
    @GET
    @Produces("application/json")
    public Response getProdutos() {
        // Retorna diretamente o resultado de findAll()
        // Futuramente podemos criar os parâmetros de busca para paginação
        // Conforme a especificação
        List<Produto> produtos = produtoService.findAll();
        GenericEntity<List<Produto>> entity = new GenericEntity<List<Produto>>(produtos) {};
        
        return Response.ok(entity).build();
    }
    
    @POST
    @Consumes("application/json")
    public Response postProdutos(Produto produto) {
        //TODO: Tratamento de erro!
        produtoService.save(produto);
        // Cria a URI com o ID do produto que acabamos de criar
        URI createdUri = uriInfo.getAbsolutePathBuilder().path(produto.getId()
                .toString()).build();
                
        return Response.created(createdUri).build();
        
    }
    
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public Response atualizaProdutos(@PathParam("id")Long id, Produto produto) {
        //TODO: Tratamento de erro!
        produtoService.update(produto);
        // Cria a URI com o ID do produto que acabamos de criar
        URI createdUri = uriInfo.getAbsolutePathBuilder().path(produto.getId()
                .toString()).build();
                
        return Response.ok(produto).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getProduto(@PathParam("id") Long id) {
        Produto produto = produtoService.find(id);
        return Response.ok(produto).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response deleteProduto(@PathParam("id") Long id) {
        Produto produto = produtoService.find(id);
        produtoService.delete(produto);
        return Response.ok().build();
    }
}
