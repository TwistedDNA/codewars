package active.learning.count.ip;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountIPAddressesTest {
    @Test
    public void test01() {
        assertEquals( 50, CountIPAddresses.ipsBetween( "10.0.0.0", "10.0.0.50" ) );
    }
    @Test
    public void test02(){
        assertEquals( 246, CountIPAddresses.ipsBetween( "20.0.0.10", "20.0.1.0" ) );
    }
    @Test
    public void test03(){
        assertEquals( 255, CountIPAddresses.ipsBetween( "20.0.0.1", "20.0.1.0" ) );
    }

}