package ch.css.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void getCalibrationValueFromThreeNumbers() {
        String input = "1ab4c2";
        int expected = 12;

        int actual = testee.getCalibrationValue(input);

        assertEquals(expected, actual);
    }
}