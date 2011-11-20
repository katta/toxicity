package org.katta.labs.metrics.toxicity.check;

public class MethodLengthCheck extends Check {

    @Override
    protected String getErrorFormat() {
        return "Method length is %{actual} lines (max allowed is %{limit}).";
    }
}
