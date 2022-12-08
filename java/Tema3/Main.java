package Tema3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

   
    public class SumInMillimeters {
        /*
         * Pattern explained
         * (\\+|\\-)      -> plus or minus character (\\ escapes the character => it refers to the actual character not the regex operator)
         * (\\+|\\-)?     -> repeats 0 or 1 times
         * ( +)           -> character space " " repeats 0 or more times
         * (\\d+)         -> there's a digit that repeats 1 or more times
         * (mm|cm|...|m)  -> one of the following sets of characters mm or cm or dm or km or m
         */

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
