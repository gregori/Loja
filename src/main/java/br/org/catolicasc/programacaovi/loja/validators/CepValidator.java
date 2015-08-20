/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author rodrigo
 */
public class CepValidator implements
            ConstraintValidator<Cep, String> {
 
  private final Pattern pattern = 
          Pattern.compile("[0-9]{5}-[0-9]{3}");
 
  @Override
  public void initialize(Cep constraintAnnotation) {
 
  }
 
    /**
     * isValid
     * @param value
     * @param context
     * @return
     */
    @Override
  public boolean isValid(String value, 
           ConstraintValidatorContext context) {
    Matcher m = pattern.matcher(value);
    return m.matches();
  }
 
}