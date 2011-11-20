package org.katta.labs.metrics.toxicity.check;

public class NestedIfDepthCheck extends Check {

    @Override
    protected String getErrorFormat() {
        return "Nested if-else depth is %{actual} (max allowed is %{limit}).";
    }
}
