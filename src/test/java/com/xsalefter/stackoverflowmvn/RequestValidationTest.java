package com.xsalefter.stackoverflowmvn;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xsalefter.stackoverflowmvn.dto.Request;
import com.xsalefter.stackoverflowmvn.dto.Request.IdOrCodeValidationGroup;

public class RequestValidationTest {

    private static final Logger LOG = LoggerFactory.getLogger(RequestValidationTest.class);

    private static ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeClass
    public static void beforeClass() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
    }

    @AfterClass
    public static void afterClass() {
        if (validatorFactory != null)
            validatorFactory.close();
    }

    @Before
    public void before() {
        this.validator = validatorFactory.getValidator();
    }

    @Test
    public void testValidation() {
        // Of course all of this valid. 
        final Request request = new Request("ID-001", 111, "Data 1");
        final Set<ConstraintViolation<Request>> fails = this.validator.validate(request);
        Assert.assertTrue(fails.isEmpty());
    }

    @Test
    public void testValidationWithGroup() {
        // We use "IdOrCodeValidationGroup.class" group, thus this is invalid.
        Request request = new Request("ID-001", 111, "Data 1");
        Set<ConstraintViolation<Request>> fails = this.validator.validate(request, IdOrCodeValidationGroup.class);
        Assert.assertFalse(fails.isEmpty());

        // Lets make one of constraint true; In this case, we set code = 0.
        request = new Request("ID-002", 0, "Data 2");
        fails = this.validator.validate(request, IdOrCodeValidationGroup.class);
        // Passed!
        Assert.assertFalse(fails.isEmpty()); 
    }
}
