package active.learning.numbers.outlier;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindOutlierTest {
    @Test
    public void test1() {
        int[] exampleTest1 = {2, 6, 8, -10, 3};
        assertEquals(3, FindOutlier.find(exampleTest1));
    }

    @Test
    public void test2() {
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        assertEquals(206847684, FindOutlier.find(exampleTest2));
    }

    @Test
    public void test3() {
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(0, FindOutlier.find(exampleTest3));
    }
    @Test
    public void test4() {
        int[] exampleTest4 = {1,2,3,5};
        assertEquals(2, FindOutlier.find(exampleTest4));
    }
    @Test
    public void test5() {
        int[] exampleTest5 = {1,2,4,6};
        assertEquals(1, FindOutlier.find(exampleTest5));
    }
    @Test
    public void test6() {
        int[] exampleTest6 = {2,4,6,7};
        assertEquals(7, FindOutlier.find(exampleTest6));
    }
    @Test
    public void test7() {
        int[] exampleTest7 = {-3,0,2,4};
        assertEquals(-3, FindOutlier.find(exampleTest7));
    }
}