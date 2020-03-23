package com.java.mask.antn;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.java.mask.ser.MaskSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = MaskSerializer.class)
public @interface Mask {
    String regex() default "";
    String beanId() default "";
    char maskingCharacter() default 'X';
}
