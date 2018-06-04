import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Alejandra Monge
 * @since 03/06/2018
 */
public class OptimusPrimeTest {

    @Test
    public void primeReduction() {
        OptimusPrime.primeReduction(2);
        OptimusPrime.primeReduction(3);
        OptimusPrime.primeReduction(5);
        OptimusPrime.primeReduction(76);
        OptimusPrime.primeReduction(100);
        OptimusPrime.primeReduction(2001);
        OptimusPrime.primeReduction(1000000000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void primeReduction_4() {
        OptimusPrime.primeReduction(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void primeReduction_1() {
        OptimusPrime.primeReduction(1);
    }

    @Test
    public void getPrimeFactors_10() throws Exception {
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(2);
        expectedResult.add(5);


        List<Integer> result = OptimusPrime.getPrimeFactors(10);

        assertEquals(expectedResult, result);
    }

    @Test
    public void getPrimeFactors_16() throws Exception {
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);

        List<Integer> result = OptimusPrime.getPrimeFactors(16);

        assertEquals(expectedResult, result);
    }

    @Test
    public void getPrimeFactors_231() {
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(3);
        expectedResult.add(7);
        expectedResult.add(11);


        List<Integer> result = OptimusPrime.getPrimeFactors(231);

        assertEquals(expectedResult, result);
    }

    @Test
    public void getPrimeFactors_76() {
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(19);


        List<Integer> result = OptimusPrime.getPrimeFactors(76);

        assertEquals(expectedResult, result);
    }

    @Test
    public void getPrimeFactors_23() {
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(23);


        List<Integer> result = OptimusPrime.getPrimeFactors(23);

        assertEquals(expectedResult, result);
    }

    @Test
    public void getPrimeFactors_2() {
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(2);

        List<Integer> result = OptimusPrime.getPrimeFactors(2);

        assertEquals(expectedResult, result);
    }


}