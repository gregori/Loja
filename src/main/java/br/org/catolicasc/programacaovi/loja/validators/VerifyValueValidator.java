/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.validators;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementação para a annotation customizada @VerifyValue
 * É um validador genérico que verifica o valor de qualquer enum
 * Se um objeto Enum tem um método getValue() ele vai validar baseado neste
 * valor, senão, utilizará o EnumConstant
 * @author rodrigo
 */
public class VerifyValueValidator implements ConstraintValidator<VerifyValue, Object> {

    Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(final VerifyValue enumObject) {
        enumClass = enumObject.value();

    }

    /**
     * Checa se o valor especificado é válido
     * @param myval  O valor para o objeto
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(final Object myval,
                           final ConstraintValidatorContext constraintValidatorContext) {


        if ((myval != null) && (enumClass != null)) {
            Enum[] enumValues = enumClass.getEnumConstants();
            Object enumValue = null;

            for (Enum enumerable : enumValues)   {
                if (myval.equals(enumerable.toString()) ) return true;
                enumValue = getEnumValue(enumerable);
                if ((enumValue != null)
                        && (myval.toString().equals(enumValue.toString())))  {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Invokes the getValue() method for enum if present
     * @param enumerable The Enum object
     * @return  returns the value of enum from getValue() or
     *          enum constant
     */
    private Object getEnumValue(Enum<?> enumerable) {
        try {
            for (Method method: enumerable.getClass().getDeclaredMethods()) {
                if (method.getName().equals("getValue")) {
                    return method.invoke(enumerable);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
