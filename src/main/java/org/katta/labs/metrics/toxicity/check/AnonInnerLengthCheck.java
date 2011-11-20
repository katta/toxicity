package org.katta.labs.metrics.toxicity.check;

public class AnonInnerLengthCheck extends Check {
    @Override
    protected String getErrorFormat() {
        return "Anonymous inner class length is %{actual} lines (max allowed is %{limit}).";
    }
}
