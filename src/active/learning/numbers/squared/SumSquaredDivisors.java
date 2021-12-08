package active.learning.numbers.squared;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        List<Long[]> result = new ArrayList<>();
        for (long i = m; i <= n; i++) {
            Set<Long> divisors = divisorsOfNumber(i);
            Long sumOfSquaredDivisors = divisors.stream().map(e -> e*e).reduce(Long::sum).orElse(0L);
            Long potentialSqrRootOfSquaredDivisor = Double.valueOf(Math.sqrt(sumOfSquaredDivisors)).longValue();
            if (sumOfSquaredDivisors % potentialSqrRootOfSquaredDivisor == 0 && sumOfSquaredDivisors / potentialSqrRootOfSquaredDivisor == potentialSqrRootOfSquaredDivisor) {
                result.add(new Long[]{i, sumOfSquaredDivisors});
            }
        }
        return formatOutput(result);
    }

    private static String formatOutput(List<Long[]> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < result.size(); i++) {
            Long[] pair = result.get(i);
            sb.append("[").append(pair[0]).append(", ").append(pair[1]).append("]");
            if (i < result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        long i = 2500;
        long potentialSqrRoot = Double.valueOf(Math.sqrt(i)).longValue();
        if (i % potentialSqrRoot == 0 && i / potentialSqrRoot == potentialSqrRoot) {
            System.out.println(potentialSqrRoot);
        }
    }

    private static Set<Long> divisorsOfNumber(long n) {
        long limit = (long) Math.ceil(Math.sqrt(n));
        Set<Long> divisors = new HashSet<>();

        for (long i = 1; i <= limit; i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }
        return divisors;
    }
}
