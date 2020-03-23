package com.java.mask.model;

import java.util.function.Function;

public class MaskingContext {
    private String regex;
    private String beanId;
    private Object input;
    private Character maskingCharacter;

    public MaskingContext(String regex, String beanId) {
        this.regex = regex;
        this.beanId = beanId;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    public Character getMaskingCharacter() {
        return maskingCharacter;
    }

    public void setMaskingCharacter(Character maskingCharacter) {
        this.maskingCharacter = maskingCharacter;
    }
}
