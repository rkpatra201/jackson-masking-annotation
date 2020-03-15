package com.java.mask.handler.impl;

import com.java.mask.handler.IMaskingHandler;
import com.java.mask.model.MaskingContext;

public class DebitCardMaskingHandlerImpl implements IMaskingHandler {
    public String doMasking(MaskingContext context) {
        return context + " masked dc";
    }
}
