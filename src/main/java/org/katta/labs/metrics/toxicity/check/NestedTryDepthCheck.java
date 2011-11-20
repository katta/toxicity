package org.katta.labs.metrics.toxicity.check;

public class NestedTryDepthCheck extends Check {

    @Override
    protected String getErrorFormat() {
        return "Nested try depth is %{actual} (max allowed is %{limit}).";
    }
}
