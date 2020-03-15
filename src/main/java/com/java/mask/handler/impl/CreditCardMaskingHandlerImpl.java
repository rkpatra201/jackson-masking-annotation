package com.java.mask.handler.impl;

import com.java.mask.handler.IMaskingHandler;
import com.java.mask.model.MaskingContext;

public class CreditCardMaskingHandlerImpl implements IMaskingHandler {
    public String doMasking(MaskingContext context) {
        return context.getInput()+" masked cc";
    }
}
