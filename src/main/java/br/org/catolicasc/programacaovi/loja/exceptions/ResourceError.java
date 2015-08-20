/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta é uma classe POJO, que contém o código de erro
 * e a mensagem, e será enviada como parte da resposta HTTP
 * @author rodrigo
 */
@XmlRootElement
public class ResourceError {

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResourceError(){

    }
}