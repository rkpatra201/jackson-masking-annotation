package com.java.mask.handler.impl;

import com.java.mask.generator.IMaskingGenerator;
import com.java.mask.handler.IMaskingHandler;
import com.java.mask.manager.MaskingGeneratorManager;
import com.java.mask.model.MaskingContext;
import com.java.mask.model.MaskingDefinition;

import java.util.function.Function;

public abstract class AbstractMaskingHandlerImpl implements IMaskingHandler {

    private Function<MaskingDefinition, Object> function;

    AbstractMaskingHandlerImpl(Function<MaskingDefinition, Object> function) {
        this.function = function;
    }

    public Object doMasking(MaskingContext context) {
        for (IMaskingGenerator maskingProvider : MaskingGeneratorManager.getGenerators()) {
            if (maskingProvider.supports(context.getInput())) {
                return maskingProvider.mask(function, context);
            }
        }
        return context.getInput();
    }
}
