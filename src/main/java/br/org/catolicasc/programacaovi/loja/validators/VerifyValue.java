/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.validators;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Uma anotação genérica para verificar objetos do tipo Enum
 * @author rodrigo
 */
// Duracao da anotação - tempod e execucao
@Retention(RUNTIME)
// Essa annotation sera aplicada a campos/variaveis de classe e metodos
@Target({FIELD, METHOD})
// Essa classe sera documentada no javadoc
@Documented
// Classe responsável pela validação
@Constraint(validatedBy = VerifyValueValidator.class)
public @interface VerifyValue {

        String message() default "O valor especificado não é válido.";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
        Class<? extends Enum<?>> value();

}
