package active.learning.unique.number;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueNumberTest {
    private double precision = 0.0000000000001;

    @Test
    public void test01() {
        assertEquals(1.0, UniqueNumber.findUniq(new double[]{0, 1, 0}), precision);
    }
    @Test
    public void test02(){
        assertEquals(2.0, UniqueNumber.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
    @Test
    public void test03(){
        assertEquals(7.0, UniqueNumber.findUniq(new double[]{6.99999, 6.99999, 7}), precision);
    }
}