/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.authenticator;

import br.org.catolicasc.programacaovi.loja.entities.Usuario;
import br.org.catolicasc.programacaovi.loja.exceptions.NotAuthenticatedException;
import br.org.catolicasc.programacaovi.loja.managers.SimpleEntityManager;
import br.org.catolicasc.programacaovi.loja.services.UsuarioService;
import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * Filtro que fará a autenticação dos usuários por token
 * @author rodrigo
 */
@Provider
@Authenticated
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) 
            throws IOException {
        SimpleEntityManager s = new SimpleEntityManager("LojaPU");
        UsuarioService usrService = new UsuarioService(s);
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        String token = headers.getFirst("token");
        System.out.println("token: " + token);
        Boolean authenticated = false;

        Usuario u = usrService.findByToken(token);
        authenticated = (null != u);
        if (!authenticated)
            throw new NotAuthenticatedException("É necessária autenticação para acessar este recurso");

        
        
    }
    
}
