package org.katta.labs.metrics.toxicity.domain;

import org.katta.labs.metrics.toxicity.check.Checks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckstyleFiles extends ArrayList<CheckstyleFile> {

    public Map<String, Map<String, Double>> calculateToxicValue() {
        Map<String, Map<String, Double>> toxicValues = new HashMap<String, Map<String, Double>>();

        for (CheckstyleFile checkstyleFile : this) {
            toxicValues.put(checkstyleFile.getName(), Checks.all().calculateToxicValue(checkstyleFile));
        }
        return toxicValues;
    }
}
