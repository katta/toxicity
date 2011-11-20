package org.katta.labs.metrics.toxicity.check;

public class CyclomaticComplexityCheck extends Check {

    @Override
    protected String getErrorFormat() {
        return "Cyclomatic Complexity is %{actual} (max allowed is %{limit}).";
    }
}
