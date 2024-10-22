package ch.css.kata;

public class Trebuchet {

    public int getCalibrationValue(String input) {
        boolean isFirstFound = false;
        int firstDigit = 0;
        int lastDigit = 0;

        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!isFirstFound) {
                    isFirstFound = true;
                    firstDigit = Character.getNumericValue(c) * 10;
                }
                lastDigit = Character.getNumericValue(c);
            }
        }
        return firstDigit + lastDigit;
    }
}
