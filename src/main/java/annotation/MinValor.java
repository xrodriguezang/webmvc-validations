package annotation;

import annotation.validation.MinValorValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MinValorValidation.class)
public @interface MinValor {

    double value() default 0;
    String message()  default "No compleix el valor mínim";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

}
