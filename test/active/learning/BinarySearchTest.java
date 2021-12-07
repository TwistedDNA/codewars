package active.learning;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchTest {
    private BinarySearch bs = new BinarySearch();

    @Test
    public void shouldTake1Step(){
        int[] sortedArray = new int[]{1,2,3};
        int returnedValue = bs.binarySearch(sortedArray, 2,0,2);
        assertEquals(1, bs.getStepsTaken());
        assertEquals(2, returnedValue);
    }

    @Test
    public void shouldTake3Steps(){
        int[] sortedArray = new int[]{1,2,3,4,5,6,7};
        int result = bs.binarySearch(sortedArray, 1,0,7);
        assertEquals(3, bs.getStepsTaken());
        assertEquals(1, result);
    }
    @Test
    public void shouldProperlySplitArray(){
        int[] sortedArray = new int[]{1,2,3,4,5,6,7,22,74,198,202,1908};
        int result = bs.binarySearch(sortedArray, 202,0,11);
        assertEquals(202, result);
    }
    @Test
    public void shouldEfficientlySearchBigArray(){
        int arraySize = 1_000_000_000;
        int[] sortedArray = new int[arraySize];
        for(int i=0;i<arraySize;i++){
            sortedArray[i] = i;
        }

        int result = bs.binarySearch(sortedArray, arraySize-1,0,arraySize-1);

        double log2 = Math.log(arraySize) / Math.log(2);  // max steps = log2(arraySize)
        int expectedStepsTaken = (int)Math.ceil(log2);  //for 1KK arraySize is 30
        System.out.println("Time elapsed:"+bs.getMillis());
        assertEquals(arraySize-1, result);
        assertEquals(expectedStepsTaken, bs.getStepsTaken());
        assertTrue(30 > bs.getMillis());
    }
}