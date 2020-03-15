package com.java.mask.model;

public class MaskingContext {
    private String regex;
    private String beanId;
    private String input;

    public MaskingContext(String regex, String beanId, String input) {
        this.regex = regex;
        this.beanId = beanId;
        this.input = input;
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
