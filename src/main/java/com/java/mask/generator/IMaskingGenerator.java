package com.java.mask.generator;

import com.java.mask.model.MaskingContext;
import com.java.mask.model.MaskingDefinition;

import java.util.function.Function;

public interface IMaskingGenerator {
    boolean supports(Object object);
    Object mask(Function<MaskingDefinition, Object> function, MaskingContext maskingContext);
}
