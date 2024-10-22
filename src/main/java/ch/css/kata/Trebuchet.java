package ch.css.kata;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Trebuchet {

    public int getCalibrationValuesFromFromFile(String input) throws IOException {
        List<String> listOfStrings = Files.readAllLines(Path.of(input));
        return listOfStrings.stream().map(this::getCalibrationValue).reduce(Integer::sum).orElseThrow();
    }

    int getCalibrationValue(String input) {
        String numbers = input.replaceAll("\\D", "");
        int length = numbers.length();

        if (numbers.isBlank()) {
            throw new IllegalArgumentException("No numbers found");
        }

        return Integer.parseInt(String.valueOf(numbers.charAt(0)) + numbers.charAt(length - 1));
    }
}
