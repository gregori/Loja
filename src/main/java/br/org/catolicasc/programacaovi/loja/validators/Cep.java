/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author rodrigo
 */
// Classe responsável pela validação
@Constraint(validatedBy = CepValidator.class)
// Essa classe sera documentada via JavaDoc
@Documented
// Essa annotation sera aplicada a campos/variaveis de classe
@Target(ElementType.FIELD)
// Duracao da anotação - tempod e execucao
@Retention(RetentionPolicy.RUNTIME)
public @interface Cep {
    
    String message() default "Cep inválido";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
 
}