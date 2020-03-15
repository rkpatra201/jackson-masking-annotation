package com.java.mask.handler.impl;

import com.java.mask.model.MaskingDefinition;

import java.util.function.Function;

public class DefaultMaskingHandlerImpl extends AbstractMaskingHandlerImpl {

    public DefaultMaskingHandlerImpl() {
        super(new DefaultMaskingFunction());
    }

    private final static class DefaultMaskingFunction implements Function<MaskingDefinition, Object> {
        @Override
        public Object apply(MaskingDefinition o) {
            return o.getValue().toString().replaceAll("1", String.valueOf(o.getMaskingCharacter()));
        }
    }
}