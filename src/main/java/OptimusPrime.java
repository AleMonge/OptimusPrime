import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alejandra Monge
 * @since 03/06/2018
 *
 */
public class OptimusPrime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();

            if (n == 4) {
                return;
            }
            primeReduction(n);
        }
    }


    /**
     * Prints the value produced by prime reduction executed on the input,
     * followed by the number of times prime factors calculation was executed.
     * @param number input to calculate prime reduction.
     */
    public static void primeReduction(Integer number) {
        if (number == 4) {
            throw new IllegalArgumentException("Number 4 produces an infinite loop in this algorithm");
        }

        if (number < 2) {
            throw new IllegalArgumentException("By definition input should be greater than or equal to 2");
        }

        Integer primeFactorsExecutionCounter = 1;
        List<Integer> primeFactors = getPrimeFactors(number);

        while (primeFactors.size() > 1) {
            Integer primeFactorsSum = primeFactors.stream().mapToInt(Integer::intValue).sum();
            primeFactors = getPrimeFactors(primeFactorsSum);
            primeFactorsExecutionCounter++;
        }

        System.out.println(primeFactors.get(0) + " " + primeFactorsExecutionCounter);
    }

    /**
     * Returns a list of prime factors for the given number.
     */
    public static List<Integer> getPrimeFactors(Integer number) {
        List<Integer> primeFactors = new ArrayList<>();


        // Divide number by 2 as many times as possible
        while (isDivisible(number, 2)) {
            primeFactors.add(2);
            number /= 2;
        }

        // Number is odd.
        // The difference between 2 prime numbers must be at least 2 that's why index+=2 increments
        // It runs until square root of current number value base on the following property for compose numbers:
        // Every composite number has at least one prime factor less than or equal to square root of itself.
        for (int index = 3; index <= Math.sqrt(number); index+=2) {
            while (isDivisible(number, index)) {
                primeFactors.add(index);
                number /= index;
            }
        }

        // Prime number greater than 2
        if (number > 2) {
            primeFactors.add(number);
        }

        return primeFactors;
    }

    /**
     * Returns true if first argument is divisible by second argument otherwise
     * returns false
     */
    private static boolean isDivisible(Integer a, Integer b) {
        return a % b == 0;
    }

}
