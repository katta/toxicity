package org.katta.labs.metrics.toxicity.domain;

import java.util.ArrayList;
import java.util.Collection;

public class CheckstyleErrors extends ArrayList<CheckstyleError> {

    public CheckstyleErrors(int i) {
        super(i);
    }

    public CheckstyleErrors() {
    }

    public CheckstyleErrors(Collection<? extends CheckstyleError> checkstyleErrors) {
        super(checkstyleErrors);
    }
}
