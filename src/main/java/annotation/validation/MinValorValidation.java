package annotation.validation;

import annotation.MinValor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class MinValorValidation implements ConstraintValidator<MinValor, BigDecimal> {

    Double valorMin;

    @Override
    public void initialize(MinValor annotacio) {
        ConstraintValidator.super.initialize(annotacio);
        valorMin = annotacio.value();
    }


    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        Double valor = value.doubleValue();

        if ( valor.compareTo(valorMin) >= 0) {
            return true;
        }
        return false;
    }
}
