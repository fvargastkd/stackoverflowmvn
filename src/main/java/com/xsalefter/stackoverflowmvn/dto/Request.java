package com.xsalefter.stackoverflowmvn.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Request {

    public interface IdOrCodeValidationGroup {}

    @NotNull
    @NotEmpty
    private String id;

    @Digits(integer=4, fraction=0)
    private double code;

    @NotNull
    @NotEmpty
    private String name;

    @AssertTrue(groups = IdOrCodeValidationGroup.class)
    private boolean idOrCodeFilled;

    public Request(String id, double code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public double getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isIdOrCodeFilled() {
        if (id == null && code > 0) {
            idOrCodeFilled = true;
        } else if (id != null && code == 0) {
            idOrCodeFilled = true;
        } else idOrCodeFilled = false;
        return idOrCodeFilled;
    }

}