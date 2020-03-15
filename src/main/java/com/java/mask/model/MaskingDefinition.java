package com.java.mask.model;

public class MaskingDefinition {
    private Object value;
    private char maskingCharacter;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public char getMaskingCharacter() {
        return maskingCharacter;
    }

    public void setMaskingCharacter(char maskingCharacter) {
        this.maskingCharacter = maskingCharacter;
    }
}
