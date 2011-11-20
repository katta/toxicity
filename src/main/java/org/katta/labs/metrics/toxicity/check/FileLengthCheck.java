package org.katta.labs.metrics.toxicity.check;

public class FileLengthCheck extends Check {

    @Override
    protected String getErrorFormat() {
        return "File length is %{actual} lines (max allowed is %{limit}).";
    }
}
