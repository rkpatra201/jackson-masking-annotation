package com.java.mask.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.java.mask.handler.IMaskingHandler;
import com.java.mask.manager.MaskingHandlerManager;
import com.java.mask.antn.Mask;
import com.java.mask.model.MaskingContext;

import java.io.IOException;

public class MaskSerializer extends StdSerializer<String> implements ContextualSerializer {


    private MaskingContext maskingContext;

    public MaskSerializer(MaskingContext maskingContext) {
        super(String.class);
        this.maskingContext = maskingContext;
    }

    public MaskSerializer() {
        super(String.class);
    }

    public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        String maskedValue = null;
        if (maskingContext.getRegex() != null && maskingContext.getRegex().length() > 0) {
            maskedValue = value.replaceAll(maskingContext.getRegex(), "X");
        } else {
            MaskingHandlerManager manager = MaskingHandlerManager.getInstance();
            IMaskingHandler handler = manager.getHandler(maskingContext.getBeanId());
            if (handler == null) {
                throw new UnsupportedOperationException("no masking strategy found for the beanId: " + maskingContext.getBeanId());
            }
            maskedValue = handler.doMasking(value);
        }
        jgen.writeString(maskedValue);
    }

    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        String beanId = null;
        String regex = null;
        Mask ann = null;
        if (property != null) {
            ann = property.getAnnotation(Mask.class);
        }
        if (ann != null) {
            beanId = ann.beanId();
            regex = ann.regex();
            MaskingContext maskingContext = new MaskingContext(regex, beanId, property.toString());
            return new MaskSerializer(maskingContext);
        }
        return null;
    }
}
