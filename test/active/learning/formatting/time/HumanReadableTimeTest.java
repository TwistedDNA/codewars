package active.learning.formatting.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanReadableTimeTest {
    @Test
    public void test1() {
        assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
    }

    @Test
    public void test2() {
        assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
    }

    @Test
    public void test3() {
        assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
    }

    @Test
    public void test4() {
        assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
    }

    @Test
    public void test5() {
        assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
    }
}
