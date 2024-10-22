package ch.css.kata;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("\\d+");

        String numbers = pattern.matcher(input).results().map(MatchResult::group).reduce((first, second) -> second) // Get the last match
                .map(last -> appendFirstToLast(input, last, pattern)).orElse("");
        return Integer.parseInt(numbers);
    }

    private static String appendFirstToLast(String input, String last, Pattern pattern) {
        return pattern.matcher(input)
                .results()
                .findFirst()
                .map(first -> first.group() + last)
                .orElse(last);
    }
}
