package org.katta.labs.metrics.toxicity;

import org.junit.Test;

import java.util.Map;

public class ToxicityCalculatorTest {

    @Test
    public void shouldLoadCheckstyleXml() {

        String checkstyleFilePath = this.getClass().getClassLoader().getResource("checkstyle.xml").getPath();
        ToxicityCalculator loader = new ToxicityCalculator(checkstyleFilePath);

        Map<String,Map<String,Double>> values = loader.calculate();

        System.out.println(loader.summary(values));
        System.out.println(loader.toCsv(values));
    }
}
