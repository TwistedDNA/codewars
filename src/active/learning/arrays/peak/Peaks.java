package active.learning.arrays.peak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Peaks {

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        // Your code here!

        Map<String, List<Integer>> results = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        if (arr.length < 3) {
            results.put("pos", pos);
            results.put("peaks", peaks);
            return results;
        }
        Integer potentialPeak = null;
        Integer potentialPeakPos = null;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                potentialPeak = arr[i];
                potentialPeakPos = i;
            }
            if (potentialPeak != null && arr[i] < potentialPeak) {
                peaks.add(potentialPeak);
                pos.add(potentialPeakPos);
                potentialPeak = null;
                potentialPeakPos = null;
            }
        }
        results.put("pos", pos);
        results.put("peaks", peaks);
        return results;
    }
}
