package org.katta.labs.metrics.toxicity.check;

public class ClassFanOutComplexityCheck extends Check {
    @Override
    protected String getErrorFormat() {
        return "Class Fan-Out Complexity is %{actual} (max allowed is %{limit}).";
    }
}
