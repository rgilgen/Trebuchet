package ch.css.kata;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Trebuchet {

    public int getCalibrationValue(String input) {
        Pattern pattern = Pattern.compile("\\d+");

        String numbers = pattern
                .matcher(input)
                .results()
                .map(match -> match.group())
                .collect(Collectors.joining(""));
        return Integer.valueOf(numbers);
    }
}
