package com.validate.demo.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * IntegerEnum.
 *
 * @author shitianyu 2021-09-30 14:53
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IntegerEnumValidator.class)
public @interface IntegerEnum {

    String message() default "invalid number";

    int[] values() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
