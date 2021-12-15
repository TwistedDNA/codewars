package active.learning.numbers.closest.sum;

import java.util.*;

public class ClosestSum {
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        if (k > ls.size()) {
            return null;
        }
        return removeOne(ls, 0, k, 0)
                .stream()
                .filter(e -> e <= t)
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    private static Set<Integer> removeOne(List<Integer> list, Integer sumOfRemoved, Integer elementsLeftToRemove, Integer startingIndex) {
        if (elementsLeftToRemove == 0) {
            return Set.of(sumOfRemoved);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startingIndex; i < list.size() - elementsLeftToRemove + 1; i++) {
            Set<Integer> sums = removeOne(list, sumOfRemoved + list.get(i), elementsLeftToRemove - 1, i + 1);
            set.addAll(sums);
        }
        return set;
    }
}
