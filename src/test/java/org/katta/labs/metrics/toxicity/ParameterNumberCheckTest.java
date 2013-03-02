package org.katta.labs.metrics.toxicity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.katta.labs.metrics.toxicity.check.ParameterNumberCheck;
import org.katta.labs.metrics.toxicity.domain.CheckstyleError;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

public class ParameterNumberCheckTest{

    private ParameterNumberCheck check;

    @Before
    public void setUp() {
        check = new ParameterNumberCheck();
    }

    @Test
    public void shouldCalculateToxicValueIfMethodParametersCheckExists() {

        CheckstyleFile file = new CheckstyleFile();

        CheckstyleError error = new CheckstyleError();
        error.setMessage("More than 6 parameters.");
        error.setSource("com.puppycrawl.tools.checkstyle.checks.sizes.ParameterNumberCheck");

        file.addError(error);

        //when
        double toxicValue = check.calculateToxicValue(file);

        //then
        Assert.assertEquals(1.0, toxicValue, 0.0);
    }

    @Test
    public void shouldCalculateToxicValueAsZeroIfMethodParametersCheckDoesNotExists() {

        CheckstyleFile file = new CheckstyleFile();

        CheckstyleError error = new CheckstyleError();
        error.setMessage("Some ranbdom Message");
        error.setSource("com.puppycrawl.tools.checkstyle.checks.sizes.MethodCheck");

        file.addError(error);

        //when
        double toxicValue = check.calculateToxicValue(file);

        //then
        Assert.assertEquals(0.0, toxicValue, 0.0);
    }
}
