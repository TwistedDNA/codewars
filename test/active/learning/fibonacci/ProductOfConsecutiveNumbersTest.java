package active.learning.fibonacci;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProductOfConsecutiveNumbersTest {
    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProductOfConsecutiveNumbers.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProductOfConsecutiveNumbers.productFib(5895));
    }
}