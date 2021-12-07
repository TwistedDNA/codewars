package active.learning;

import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearch {
    private AtomicInteger stepsTaken = new AtomicInteger(0);
    private long millis = 0;

    public void reset() {
        stepsTaken.set(0);
        millis = 0;
    }

    public int getStepsTaken() {
        return stepsTaken.get();
    }

    public long getMillis() {
        return millis;
    }

    public Integer binarySearch(int[] sortedArray, int valueToLookFor, int start, int end) {
        reset();
        millis = System.currentTimeMillis();
        Integer result = bs(sortedArray, valueToLookFor, start, end);
        millis = System.currentTimeMillis() - millis;
        return result;
    }

    private Integer bs(int[] sortedArray, int valueToLookFor, int start, int end) {
        int middle = (start + end) / 2;
        if (sortedArray[middle] == valueToLookFor) {
            return valueToLookFor;
        }
        if (start == end) {
            //failed to find value
            return null;
        }
        if (sortedArray[middle] > valueToLookFor) {
            return bs(sortedArray, valueToLookFor, start, middle - 1);
        } else {
            return bs(sortedArray, valueToLookFor, middle + 1, end);
        }
    }
}
