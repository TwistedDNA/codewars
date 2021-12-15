package active.learning.numbers.closest.sum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ClosestSumTest {

    @Test
    public void test1() {
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = ClosestSum.chooseBestSum(163, 3, ts);
        assertEquals(163, n);
    }

    @Test
    public void test2() {
        var ts = new ArrayList<>(List.of(50));
        Integer m = ClosestSum.chooseBestSum(163, 3, ts);
        assertNull(m);
    }

    @Test
    public void test3() {
        var ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        int n = ClosestSum.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }
}