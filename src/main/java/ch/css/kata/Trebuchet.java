package ch.css.kata;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Trebuchet {

    public int getCalibrationValue(String input) {
        Pattern pattern = Pattern.compile("\\d+");

        String numbers = pattern.matcher(input).results()
                .map(MatchResult::group)
                .reduce((first, second) -> second) // Get the last match
                .map(last -> pattern.matcher(input).results().findFirst().map(first -> first.group() + last).orElse(last))
                .orElse("");
        return Integer.parseInt(numbers);
    }
}
