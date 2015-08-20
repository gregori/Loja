/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.resources;

import br.org.catolicasc.programacaovi.loja.entities.Cliente;
import br.org.catolicasc.programacaovi.loja.exceptions.ClienteNotFoundException;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import br.org.catolicasc.programacaovi.loja.services.ClienteService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
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
@Path("/clientes")
public class ClienteResource {
    // Permite injetar informação de URI na variável uriInfo
    @Context
    UriInfo uriInfo;
    
    private SimpleEntityManager simpleEntityManager;
    private ClienteService clienteService;
    private static final String persistenceUnit = "LojaPU";
    
    public ClienteResource() {
        // Inicializamos o clienteService
        // É preciso o entityManager, pois é parâmetro para o construtor do clienteService
        this.simpleEntityManager = new SimpleEntityManager(persistenceUnit);
        this.clienteService = new ClienteService(this.simpleEntityManager);
    }
    
    @GET
    @Produces("application/json")
    public Response getClientes() {
        // Retorna diretamente o resultado de findAll()
        // Futuramente podemos criar os parâmetros de busca para paginação
        // Conforme a especificação
        List<Cliente> clientes = clienteService.findAll();
        GenericEntity<List<Cliente>> entity = new GenericEntity<List<Cliente>>(clientes) {};
        
        return Response.ok(entity).build();
    }
    
    @POST
    @Consumes("application/json")
    @ValidateOnExecution
    public Response postClientes(@Valid Cliente cliente) {
        //TODO: Tratamento de erro!
        clienteService.save(cliente);
        // Cria a URI com o ID do cliente que acabamos de criar
        URI createdUri = uriInfo.getAbsolutePathBuilder().path(cliente.getId()
                .toString()).build();
                
        return Response.created(createdUri).entity(cliente).build();
        
    }
    
    @PUT
    //@Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    //public Response atualizaClientes(@PathParam("id")Long id, Cliente cliente) {
    public Response atualizaClientes(Cliente cliente) {
        //TODO: Tratamento de erro!
        clienteService.update(cliente);
                
        return Response.ok(cliente).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getCliente(@PathParam("id") Long id) {
        Cliente cliente = clienteService.find(id);
        if (cliente == null)
            throw new ClienteNotFoundException(
                    "Não foi encontrado um cliente com id " + id);
        
        return Response.ok(cliente).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response deleteCliente(@PathParam("id") Long id) {
        Cliente cliente = clienteService.find(id);
        clienteService.delete(cliente);
        return Response.ok().build();
    }
}
