package org.katta.labs.metrics.toxicity.check;

import org.junit.Assert;
import org.junit.Test;
import org.katta.labs.metrics.toxicity.domain.CheckstyleError;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

public class MethodLengthCheckTest {

    @Test
    public void shouldCalculateToxicValueIfNoOfLinesInMethodExeedTheLimit() {
        //given
        MethodLengthCheck check = new MethodLengthCheck();
        CheckstyleFile file = new CheckstyleFile();
        file.setName("file name");

        CheckstyleError checkstyleError = new CheckstyleError();
        checkstyleError.setMessage("Method length is 6 lines (max allowed is 5).");
        checkstyleError.setSource("com.puppycrawl.tools.checkstyle.checks.sizes.MethodLengthCheck");


        file.addError(checkstyleError);

        //when
        double toxicValue = check.calculateToxicValue(file);

        //then
        Assert.assertEquals(1.2, toxicValue, 0.0);
    }
}
