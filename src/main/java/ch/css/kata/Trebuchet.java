package ch.css.kata;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Trebuchet {

    public List<String> getStringFromFile(String path) throws IOException {
        File file = new File(path);
        InputStream is = Files.newInputStream(file.toPath());
        Reader reader = new InputStreamReader(is);
        try (BufferedReader r = new BufferedReader(reader)) {
            return r.lines().toList();
        }
    }

    public int getCalibrationValue(String input) {
        Pattern pattern = Pattern.compile("(\\d).*(\\d)");
        Matcher matcher = pattern.matcher(input);

        String firstAndLastDigit;
        if (matcher.find()) {
            firstAndLastDigit = matcher.group(1) + matcher.group(2);
        }
        else{
            String digit = Pattern.compile("\\d").matcher(input).results()
                    .map(MatchResult::group)
                    .collect(Collectors.joining());
            firstAndLastDigit = digit + digit;
        }
        return Integer.parseInt(firstAndLastDigit);
    }

    public int getCalibrationValuesFromFromFile(String input) throws IOException {
        List<String> listOfStrings = getStringFromFile(input);
        return listOfStrings.stream().map(this::getCalibrationValue).reduce(Integer::sum).orElseThrow();
    }
}
