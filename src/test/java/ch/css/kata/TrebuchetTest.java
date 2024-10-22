package ch.css.kata;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrebuchetTest {

    private final Trebuchet testee = new Trebuchet();

    @Test
    void getCalibrationValue() {
        String input = "1abc2";
        int expected = 12;

        int actual = testee.getCalibrationValue(input);

        assertEquals(expected, actual);
    }

    @Test
    void getCalibrationValueFromThreeNumbers68() {
        String input = "6798seven";
        int expected = 68;

        int actual = testee.getCalibrationValue(input);

        assertEquals(expected, actual);
    }

    @Test
    void getCalibrationValueFromThreeNumbers12() {
        String input = "1ab4c2";
        int expected = 12;

        int actual = testee.getCalibrationValue(input);

        assertEquals(expected, actual);
    }

    @Test
    void getCalibrationValueForOneNumber() {
        String input = "ab7c";
        int expected = 77;

        int actual = testee.getCalibrationValue(input);

        assertEquals(expected, actual);
    }

    @Test
    void getStringFromFile() throws IOException {
        String input = "src/test/resources/testInput.txt";
        List<String> expected = Arrays.asList("6798seven", "se7en");

        List<String> actual = testee.getStringFromFile(input);

        assertEquals(expected, actual);
    }

    @Test
    void getCalibrationValuesFromFromFile() throws IOException {
        String input = "src/test/resources/testInput.txt";
        int expected = 68 + 77;

        int actual = testee.getCalibrationValuesFromFromFile(input);

        assertEquals(expected, actual);
    }

}