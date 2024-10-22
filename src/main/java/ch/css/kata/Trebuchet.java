package ch.css.kata;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class Trebuchet {

    public int getCalibrationValuesFromFromFile(String input) throws IOException {
        List<String> listOfStrings = getStringFromFile(input);
        return listOfStrings.stream().map(this::getCalibrationValue).reduce(Integer::sum).orElseThrow();
    }

    List<String> getStringFromFile(String path) throws IOException {
        File file = new File(path);
        InputStream is = Files.newInputStream(file.toPath());
        Reader reader = new InputStreamReader(is);
        try (BufferedReader r = new BufferedReader(reader)) {
            return r.lines().toList();
        }
    }

    int getCalibrationValue(String input) {
        String numbers = input.replaceAll("\\D", "");

        if (numbers.isBlank()) {
            throw new IllegalArgumentException("No numbers found");
        }
        String firstAndLastDigit;
        int length = numbers.length();
        String firstNumber = String.valueOf(Character.getNumericValue(numbers.charAt(0)));
        if (length > 1) {
            firstAndLastDigit = firstNumber + Character.getNumericValue(numbers.charAt(length - 1));
        } else {
            firstAndLastDigit = firstNumber + numbers.charAt(0);
        }
        return Integer.parseInt(firstAndLastDigit);
    }
}
