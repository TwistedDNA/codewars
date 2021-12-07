package active.learning.fibonacci;

public class ProductOfConsecutiveNumbers {
    public static long[] productFib(long prod) {
        long previous = 1;
        long current = 1;
        while(previous*current<prod){
            long temp = previous;
            previous = current;
            current = previous + temp;
        }
        return new long[]{previous, current, (previous*current==prod) ? 1 : 0};
    }
}
