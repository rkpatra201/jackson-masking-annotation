package com.java.mask.generator.impl;

import com.java.mask.model.MaskingContext;
import com.java.mask.model.MaskingDefinition;

import java.util.*;
import java.util.function.Function;

public class MultiValueMaskingGenerator extends SingleValueMaskingGenerator {
    public boolean supports(Object object) {
        return isCollection(object);
    }

    public Object mask(Function<MaskingDefinition, Object> function, MaskingContext maskingContext) {

        Object input = maskingContext.getInput();
        Enumeration enumeration = null;
        if (input.getClass().isArray()) {
            Object[] objects = (Object[]) input;
            List<Object> objectAsList = Arrays.asList(objects);
            enumeration = Collections.enumeration(objectAsList);
        } else {
            enumeration = Collections.enumeration((Collection) input);
        }
        List<Object> result = new ArrayList<Object>();
        while (enumeration.hasMoreElements()) {
            Object object = enumeration.nextElement();
            if (super.supports(object)) {
                MaskingDefinition maskingDefinition = super.createMaskingDefinition(object, maskingContext.getMaskingCharacter());
                Object masked = function.apply(maskingDefinition);
                result.add(masked);
            } else {
                result.add(object);
            }
        }
        return result;
    }

    public static boolean isCollection(Object obj) {
        return obj.getClass().isArray() || obj instanceof Collection;
    }
}
