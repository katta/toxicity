package org.katta.labs.metrics.toxicity.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String join(String delimiter, List<String> values) {
        StringBuilder builder = new StringBuilder();

        for (String value : values) {
            builder.append(value).append(delimiter);
        }
        String joinedString = builder.toString();
        return joinedString.substring(0, joinedString.length() - 1);
    }

    public static Map<String, String> collectParams(String format, String actual) {

        HashMap<String, String> result = new HashMap<String, String>();
        format = format.replaceAll("\\(", "<").replaceAll("\\)", ">");
        actual = actual.replaceAll("\\(", "<").replaceAll("\\)", ">");

        String regex = format.replaceAll("%\\{[^}]*}", "(.*?)") + "$";
        Pattern pattern = Pattern.compile(regex);
        Matcher formatMatcher = pattern.matcher(format);
        Matcher actualMatcher = pattern.matcher(actual);

        if (formatMatcher.find() && actualMatcher.find()) {
            for (int i = 1; i <= formatMatcher.groupCount(); i++) {
                result.put(formatMatcher.group(i).substring(2, formatMatcher.group(i).length() - 1), actualMatcher.group(i));
            }
        }

        return result;
    }
}
