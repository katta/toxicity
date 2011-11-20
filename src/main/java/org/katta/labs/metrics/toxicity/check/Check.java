package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleError;
import org.katta.labs.metrics.toxicity.domain.CheckstyleErrors;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;
import org.katta.labs.metrics.toxicity.util.StringUtil;

import java.util.Map;

public abstract class Check {

    private double toxicValue = 0.0;

    public double calculateToxicValue(CheckstyleFile file) {
        CheckstyleErrors errors = errorsOfThisType(file);

        double value = 0.0;

        for (CheckstyleError error : errors) {
            Map<String, String> linesMap = StringUtil.collectParams(getErrorFormat(), error.getMessage());
            value += new Double(linesMap.get("actual").replaceAll(",", "")) / new Double(linesMap.get("limit").replaceAll(",", ""));
        }

        return value;
    }

    protected abstract String getErrorFormat();

    public String getName() {
        return this.getClass().getSimpleName();
    }

    protected CheckstyleErrors errorsOfThisType(CheckstyleFile file) {
        return file.errorsOfType(this.getClass().getSimpleName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return getName().equals(((Check) o).getName());
    }

    public void addToxicValue(double toxicValue) {
        this.toxicValue += toxicValue;
    }

    @Override
    public String toString() {
        return this.getName() + "=" + toxicValue;
    }
}
