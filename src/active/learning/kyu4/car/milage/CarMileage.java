package active.learning.kyu4.car.milage;

import java.util.regex.Pattern;

public class CarMileage {
    public static int isInteresting(int number, int[] awesomePhrases) {
        //Go to town
        if (isNumberInteresting(number, awesomePhrases))
            return 2;
        if (isNumberInteresting(number + 1, awesomePhrases) || isNumberInteresting(number + 2, awesomePhrases))
            return 1;
        return 0;
    }

    static boolean isNumberInteresting(int number, int[] awesomePhrases) {
        if (number < 100)
            return false;
        return hasZerosInTheEnd(number) &&
                everyDigitIsTheSame(number);
    }

    static boolean everyDigitIsTheSame(int number) {
        return Pattern.compile("^(.)\\1+$").matcher(Integer.toString(number)).find();
    }

    static boolean hasZerosInTheEnd(int number) {
        return Pattern.compile("^[1-9]{1}0+$").matcher(Integer.toString(number)).find();
    }
}
