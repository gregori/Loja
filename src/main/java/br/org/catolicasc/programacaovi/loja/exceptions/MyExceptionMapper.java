/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Implementação da classe ExceptionMapper, para converter uma exceção
 * definida pelo usuário em uma resposta HTTP JAX-RS
 * @author Rodrigo
 */
@Provider
public class MyExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        ResourceError resourceError = new ResourceError(); 
        // classe enviada com a resposta, contendo o erro e a mensagem
        

        String error = "O serviço encontrou um erro interno: ";
        int statusCode = 503;
        
        // Pode-se adicionar outras exceções para tratamento aqui.
        if (e instanceof ResourceNotFoundException) {
            statusCode = Response.Status.NOT_FOUND.getStatusCode();
        } else if (e instanceof NotAuthenticatedException) {
            statusCode = Response.Status.FORBIDDEN.getStatusCode();
        }
        error += e.getMessage();
        resourceError.setCode(statusCode);
        resourceError.setMessage(error);
        // Caso a exceção não seja mapeada, retorna um erro 503
        return Response.status(statusCode).entity(resourceError)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
