package com.java.mask.generator.impl;

import com.java.mask.model.MaskingContext;
import com.java.mask.generator.IMaskingGenerator;
import com.java.mask.model.MaskingDefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SingleValueMaskingGenerator implements IMaskingGenerator {

    private static final List<Class> supportedTypes = new ArrayList<>(Arrays.asList(String.class, Integer.class));

    public boolean supports(Object object) {
        return supportedTypes.contains(object.getClass());
    }

    public Object mask(Function<MaskingDefinition, Object> function, MaskingContext maskingContext) {
        MaskingDefinition maskingDefinition = createMaskingDefinition(maskingContext.getInput(), maskingContext.getMaskingCharacter());
        return function.apply(maskingDefinition);
    }


    protected MaskingDefinition createMaskingDefinition(Object input, char maskingCharacter) {
        MaskingDefinition maskingDefinition = new MaskingDefinition();
        maskingDefinition.setValue(input);
        maskingDefinition.setMaskingCharacter(maskingCharacter);
        return maskingDefinition;
    }


}
