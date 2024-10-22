package ch.css.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrebuchetTest {

    private final Trebuchet testee = new Trebuchet();

    @ParameterizedTest
    @MethodSource("calibrationValueProvider")
    void getCalibrationValue(String input, int expected) {
        int actual = testee.getCalibrationValue(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> calibrationValueProvider() {
        return Stream.of(
                Arguments.of("1abc2", 12),
                Arguments.of("6798seven", 68),
                Arguments.of("1ab4c2", 12),
                Arguments.of("ab7c", 77)
        );
    }

    @Test
    void getCalibrationValueException() {
        String input = "abc";

        assertThrows(IllegalArgumentException.class, () -> testee.getCalibrationValue(input));
    }

    @Test
    void getStringFromFile() throws IOException {
        String input = "src/test/resources/testInput.txt";
        List<String> expected = Arrays.asList("6798seven", "se7en");

        List<String> actual = Files.readAllLines(Path.of(input));

        assertEquals(expected, actual);
    }

    @Test
    void getCalibrationValuesFromFromFile() throws IOException {
        String input = "src/test/resources/testInput.txt";
        int expected = 68 + 77;

        int actual = testee.getCalibrationValuesFromFromFile(input);

        assertEquals(expected, actual);
    }

    @Test
    void getCalibrationValuesFromFromRealFile() throws IOException {
        String input = "src/main/resources/input.txt";
        int expected = 54239;

        int actual = testee.getCalibrationValuesFromFromFile(input);

        assertEquals(expected, actual);
    }

}