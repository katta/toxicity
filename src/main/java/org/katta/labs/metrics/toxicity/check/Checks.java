package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;
import org.katta.labs.metrics.toxicity.util.StringUtil;

import java.util.*;

public class Checks extends ArrayList<Check> {

    public static final String TOTAL = "total";
   
    public Checks() {
    }

    public Checks(int i) {
        super(i);
    }

    public Checks(Check... checks) {
        this(Arrays.asList(checks));
    }

    public Checks(Collection<? extends Check> checks) {
        super(checks);
    }

    public static Checks all() {
        return new Checks(new ParameterNumberCheck(), new MethodLengthCheck(),
                new NestedIfDepthCheck(), new NestedTryDepthCheck(),
                new FileLengthCheck(), new MissingSwitchDefaultCheck(),
                new CyclomaticComplexityCheck(), new ClassDataAbstractionCouplingCheck(),
                new AnonInnerLengthCheck(), new ClassFanOutComplexityCheck(),
                new BooleanExpressionComplexityCheck());
    }

    public HashMap<String, Double> calculateToxicValue(CheckstyleFile checkstyleFile) {
        HashMap<String, Double> checkValues = new HashMap<String, Double>();

        double sum = 0.0;
        for (Check check : this) {
            double toxicValueOfCheck = check.calculateToxicValue(checkstyleFile);
            sum += toxicValueOfCheck;
            checkValues.put(check.getName(), toxicValueOfCheck);
        }
        checkValues.put(TOTAL, sum);
        
        return checkValues;
    }


    public List<String> names() {
        ArrayList<String> names = new ArrayList<String>();
        for (Check check : this) {
            names.add(check.getName());
        }
        return names;
    }

    public String toCSV() {
        return StringUtil.join(",", names());
    }

    public Check find(String checkName) {
        for (Check check : this) {
            if(check.getName().equals(checkName)) return check;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Check check : this) {
            builder.append(check.toString()).append("\n");
        }
        return builder.toString();
    }
}
