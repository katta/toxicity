package org.katta.labs.metrics.toxicity.check;

import org.junit.Assert;
import org.junit.Test;
import org.katta.labs.metrics.toxicity.domain.CheckstyleError;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

public class ClassDataAbstractionCouplingCheckTest {

    @Test
    public void shouldCalculateToxicValueIfDataAbstractionCouplingExceeds() {
        //given
        ClassDataAbstractionCouplingCheck check = new ClassDataAbstractionCouplingCheck();

        CheckstyleFile file = new CheckstyleFile();

        CheckstyleError error = new CheckstyleError();
        error.setMessage("Class Data Abstraction Coupling is 11 (max allowed is 10) classes [APIException, ArdenBaseLexer, ArdenBaseParser, ArdenBaseTreeParser, ByteArrayInputStream, Date, File, FileInputStream, FileOutputStream, MLMObject, OutputStreamWriter].");
        error.setSource("com.puppycrawl.tools.checkstyle.checks.metrics.ClassDataAbstractionCouplingCheck");
        file.addError(error);

        //when
        double value = check.calculateToxicValue(file);

        //then
        Assert.assertEquals(1.1, value, 0.0);
    }
}
