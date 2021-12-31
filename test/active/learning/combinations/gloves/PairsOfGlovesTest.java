package active.learning.combinations.gloves;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PairsOfGlovesTest {
    @Test
    public void tests() {
        assertEquals(0, PairsOfGloves.numberOfPairs(new String[] {}));
        assertEquals(1, PairsOfGloves.numberOfPairs(new String[] {"red", "red"}));
        assertEquals(0, PairsOfGloves.numberOfPairs(new String[] {"red", "green", "blue"}));
        assertEquals(3, PairsOfGloves.numberOfPairs(new String[] {"gray", "black", "purple", "purple", "gray", "black"}));
        assertEquals(4, PairsOfGloves.numberOfPairs(new String[] {"red", "green", "blue", "blue", "red", "green", "red", "red", "red"}));
    }
}