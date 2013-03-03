package org.katta.labs.metrics.toxicity;

import org.katta.labs.metrics.toxicity.check.Check;
import org.katta.labs.metrics.toxicity.check.Checks;
import org.katta.labs.metrics.toxicity.domain.Checkstyle;
import org.katta.labs.metrics.toxicity.util.FileUtil;
import org.katta.labs.metrics.toxicity.util.JAXBUtil;
import org.katta.labs.metrics.toxicity.util.StringUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ToxicityCalculator {

    private String checkstyleFilePath;

    public ToxicityCalculator(String checkstyleFilePath) {
        this.checkstyleFilePath = checkstyleFilePath;
    }

    public static void main(String... args) {
        if (args == null || args.length != 2) {
            System.out.println("Usage: toxicity.jar <checkstyleFilePath> <outputCSVFilePath>");
            System.out.println("Calculates the toxicity of your code based on the checkstyle report generated for your code.");
            System.out.println("To calculate a suitable Checkstyle report use:");
            System.out.println("   checkstyle-all.jar -c toxicity/checks.xml -f xml -o <checkstyleFilePath> -r <javaSourcePath>");
            System.exit(1);
            return;
        }

        ToxicityCalculator calculator = new ToxicityCalculator(args[0]);
        Map<String, Map<String, Double>> values = calculator.calculate();

        System.out.println(calculator.summary(values));
        FileUtil.write(args[1], calculator.toCsv(values));
    }


    public Map<String, Map<String, Double>> calculate() {
        Checkstyle checkstyle = loadCheckstyle(checkstyleFilePath);
        return checkstyle.getFiles().calculateToxicValue();
    }

    String summary(Map<String, Map<String, Double>> toxicValues) {
        Checks allChecks = Checks.all();
        double totalToxicity = 0.0;
        for (Map<String, Double> values : toxicValues.values()) {
            for (String checkName : values.keySet()) {
                if (Checks.TOTAL.equals(checkName)) {
                   continue;
                }
                Double toxicity = values.get(checkName);
                allChecks.find(checkName).addToxicValue(toxicity);
                totalToxicity += toxicity;
            }
        }
        return allChecks.toString() + "\nTotal Toxicity :" + totalToxicity;
    }

    
    String toCsv(Map<String, Map<String, Double>> toxicValues) {
        NumberFormat localNumberFormat = new DecimalFormat("\"0.####\"");

        StringBuilder csv = new StringBuilder();

        Checks checks = Checks.all();
        csv.append("FileName,").append(checks.toCSV()).append("\n");

        List<String> fileNames = sortFileNamesByToxity(toxicValues);
        for (String file : fileNames) {
            List<String> values = new ArrayList<String>();
            values.add(file);

            for (Check check : checks) {
               Double toxicValueOfCheck = toxicValues.get(file).get(check.getName());
               values.add(localNumberFormat.format(toxicValueOfCheck));
            }
            
            csv.append(StringUtil.join(",", values)).append("\n");
        }
        return csv.toString();

    }

    private List<String> sortFileNamesByToxity(final Map<String, Map<String, Double>> toxicValues) {
        List<String> fileNames = new ArrayList<String>(toxicValues.keySet());
        Collections.sort(fileNames, new Comparator<String>() {
            @Override
            public int compare(String fileName1, String fileName2) {
                return toxicValues.get(fileName2).get(Checks.TOTAL).compareTo(toxicValues.get(fileName1).get(Checks.TOTAL));
            }
        });
        return fileNames;
    }

    private Checkstyle loadCheckstyle(String filePath) {
        return JAXBUtil.load(Checkstyle.class, filePath);
    }

}
