package org.katta.labs.metrics.toxicity.check;

public class BooleanExpressionComplexityCheck extends Check {
    @Override
    protected String getErrorFormat() {
        return "Boolean expression complexity is %{actual} (max allowed is %{limit}).";
    }
}
