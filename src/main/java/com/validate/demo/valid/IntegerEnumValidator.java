package com.validate.demo.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * IntegerEnumValidator.
 *
 * @author shitianyu 2021-09-30 14:54
 */
public class IntegerEnumValidator implements ConstraintValidator<IntegerEnum, Integer> {

    private IntegerEnum integerEnum;

    @Override
    public void initialize(IntegerEnum constraintAnnotation) {
        this.integerEnum = constraintAnnotation;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        int[] values = integerEnum.values();
        if (values.length == 0) {
            return true;
        }
        for (int v : values) {
            if (value == v) {
                return true;
            }
        }
        return false;
    }
}
