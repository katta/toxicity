package org.katta.labs.metrics.toxicity.check;

public class ClassDataAbstractionCouplingCheck extends Check {

    @Override
    protected String getErrorFormat() {
        return "Class Data Abstraction Coupling is %{actual} (max allowed is %{limit}).*";
    }
}
