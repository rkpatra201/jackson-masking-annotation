package com.java.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.java.mask.antn.Mask;
import com.java.mask.ser.MaskSerializer;

public class LoanAccount {
    @JsonSerialize(using = MaskSerializer.class)
    @Mask(beanId = "bean1", regex = "[^-\\\\n](?=.*?-)")
    private String creditCardNumber;
    @JsonSerialize(using = MaskSerializer.class)
    @Mask(beanId = "bean2")
    private String debitCardNumber;

    public LoanAccount(String creditCardNumber, String debitCardNumber) {
        this.creditCardNumber = creditCardNumber;
        this.debitCardNumber = debitCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }
}
