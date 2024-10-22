package ch.css.kata;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Trebuchet {

    public int getCalibrationValue(String input) {
        Pattern pattern = Pattern.compile("\\d+");

        String numbers = pattern.matcher(input).results().map(MatchResult::group).collect(Collectors.joining(""));
        return Integer.parseInt(numbers.charAt(0) + "" + numbers.charAt(numbers.length() - 1));
    }
}
