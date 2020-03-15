package com.java.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.java.mask.antn.Mask;
import com.java.mask.ser.MaskSerializer;

import java.util.Set;

public class LoanAccount {

    @JsonSerialize(using = MaskSerializer.class)
    @Mask(beanId = "bean1")
    private String creditCardNumber;

    @JsonSerialize(using = MaskSerializer.class)
    @Mask(beanId = "bean1")
    private String debitCardNumber;

    @JsonSerialize(using = MaskSerializer.class)
    @Mask(beanId = "bean1")
    private Integer mobileNumber;

    @JsonSerialize(using = MaskSerializer.class)
    @Mask(beanId = "bean1")
    private Set<Number> mobileNumbers;

    @JsonSerialize(using = MaskSerializer.class)
    @Mask(beanId = "bean1")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LoanAccount(String creditCardNumber, String debitCardNumber, Exception e) {
        this.creditCardNumber = creditCardNumber;
        this.debitCardNumber = debitCardNumber;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public Set<Number> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<Number> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }
}
