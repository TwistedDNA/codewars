package active.learning.arrays.maximum.subarray;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubArraySumTest {
    @Test
    public void testEmptyArray() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, MaximumSubArraySum.sequence(new int[]{}));
    }
    @Test
    public void testExampleArray() throws Exception {
        assertEquals("Example array should have a max of 6", 6, MaximumSubArraySum.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}