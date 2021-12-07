package active.learning.removed.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum " + sum);
        List<long[]> results = new ArrayList<>();

        for (long a = 1; a <= n; a++) {
            results.addAll(binarySearch(sum, a, 1, n));
        }
        results.sort((a, b) -> (int) (a[0] - b[0]));
        return results;
    }

    private static List<long[]> binarySearch(long sum, long a, long start, long end) {
        long middle = (start + end) / 2;
        //System.out.printf("a: %d, start: %d, middle: %d, end: %d \n", a, start, middle, end);
        if (middle == a) {
            if (start == middle && middle == end) {
                return Collections.emptyList();
            }else if(start<middle){
                middle--;
            } else {
                middle++;
            }
        }
        long reducedSum = sum - a - middle;
        if (reducedSum == a * middle) {
            List<long[]> list = new ArrayList<>();
            list.add(new long[]{a, middle});
            System.out.printf("Adding {%d,%d}", a, middle);
            return list;
        }
        if (start == end) {
            return Collections.emptyList();
        }
        if (reducedSum > a * middle) {
            if (middle == end) {
                return Collections.emptyList();
            }
            return binarySearch(sum, a, middle + 1, end);
        } else {
            if (start == middle) {
                return Collections.emptyList();
            }
            return binarySearch(sum, a, start, middle - 1);
        }
    }
}
