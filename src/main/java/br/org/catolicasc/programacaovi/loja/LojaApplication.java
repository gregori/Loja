/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja;

import com.sun.jersey.api.core.PackagesResourceConfig;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author rodrigo
 */
@ApplicationPath("/api")
public class LojaApplication extends PackagesResourceConfig {
    public LojaApplication() {
        super("br.org.catolicasc.programacaovi.loja.resources,br.org.catolicasc.programacaovi.loja.exceptions,br.org.catolicasc.programacaovi.loja.authenticator");
    }
}
