package active.learning;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/*
        Wikipedia states, that there are approximately log(n) prime numbers below n.
        Let's check if it is true
 */
public class PrimeNumberDistribution {

    public static void main(String[] args) {
        double locationOf10kPrime = (10000 * Math.log(10000)) * 1.2;
        printCoef((int)locationOf10kPrime);
    }

    private static void printCoef(long limit) {
        List<Long> primes = generatePrimes(limit);
        double maxCoef = 0;
        int maxCoefLocation = 0;
        for (int i = 0; i < primes.size(); i++) {
            Long prime = primes.get(i);
            double expectedNumberOfPrimes = prime / (Math.log(prime));
            double coef = i / expectedNumberOfPrimes;
            if(coef > maxCoef){
                maxCoef = coef;
                maxCoefLocation = i;
            }
            maxCoef = Math.max(coef, maxCoef);
            System.out.printf("%d, (%dth prime) expected amount of primes: %f, coef %f\n", prime, i, expectedNumberOfPrimes, coef);
        }
        System.out.printf("Max coef %f at %dth prime",maxCoef,maxCoefLocation);
    }

    private static List<Long> generatePrimes(long limit) {
        List<Long> numbers = LongStream.range(2, limit).boxed().collect(Collectors.toList());
        List<Long> primes = new ArrayList<>();
        while(!numbers.isEmpty()){
            Long prime = numbers.get(0);
            primes.add(prime);
            numbers.removeIf(n -> n % prime == 0);
        }
        return primes;
    }
}
