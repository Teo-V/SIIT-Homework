package Tema3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
   /**
     * This is a calculator capable of computing a metric distance value from an expression that contains different
     * scales and systems
     * Output is specified by the user.
     * <p>
     * Only Addition and subtraction is allowed.
     * <p>
     * Supported formats: mm, cm, dm, m, km.
     * <p>
     * Output is returned in lowest unit.
     * <p>
     * Ignore groups where the value characters are not numbers, the unit of measure is missing or the format is not
     * supported. If there are 2 signs for a group, the first one is ignored.
     */

   
    public class SumInMillimeters {

        private static String PATTERN_REGEX = "(\\+|\\-)?( *)(\\d+)( *)(mm|cm|dm|km|m)";

        public int sum(String string) {

            Pattern pattern = Pattern.compile(PATTERN_REGEX);
            Matcher matcher = pattern.matcher(string);

            int sum = 0;
            while (matcher.find()) {
                String group = matcher.group();
                String unitOfMeasure = extractFromString(group, "(mm|cm|dm|km|m)", null);
                String number = extractFromString(group, "(\\d+)", null);
                String sign = extractFromString(group, "(\\+|\\-)?", "+");
                sum += transformToMillimeters(unitOfMeasure, number, sign);
            }
            System.out.println("Sum: " + sum + " mm");
            return sum;
        }

        private String extractFromString(String stringToBeSearched, String patternString, String defaultData) {
            Pattern pattern = Pattern.compile(patternString);
            Matcher unitMatcher = pattern.matcher(stringToBeSearched);
            unitMatcher.find();
            String group = unitMatcher.group(1);
            if (group == null) {
                return defaultData;
            }

            return group;
        }

        private int transformToMillimeters(String unitOfMeasure, String number, String sign) {
            int distance = Integer.parseInt(number);
            switch (unitOfMeasure) {
                case "km":
                    distance = distance * 1000000;
                    break;
                case "m":
                    distance = distance * 1000;
                    break;
                case "dm":
                    distance = distance * 100;
                    break;
                case "cm":
                    distance = distance * 10;
                    break;
            }
            if (sign.equals("-")) {
                distance = distance * -1;
            }
            return distance;
        }


    }

}
