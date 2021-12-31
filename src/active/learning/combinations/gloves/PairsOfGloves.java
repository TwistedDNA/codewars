package active.learning.combinations.gloves;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsOfGloves {
    public static int numberOfPairs(String[] gloves) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(gloves).forEach(color -> {
            if(map.containsKey(color)){
                map.put(color, map.get(color) + 1);
            } else {
                map.put(color, 1);
            }
        });
        return map.values().stream().map(integer -> (Integer) integer / 2).mapToInt(Integer::intValue).sum();
    }
}
