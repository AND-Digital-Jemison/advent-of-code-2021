package adventofcode.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CodeTest {
    Code code;

    @BeforeEach()
    public void before() {
        code = new Code();
    }

    @Test
    public void testConvertData() {
        var data = Arrays.asList(new String[]{"00100", "11110"});
        var array2D = code.convertData(data.stream());
        Assertions.assertEquals(2, array2D.length);
        Assertions.assertEquals(5, array2D[0].length);
        Assertions.assertEquals(5, array2D[1].length);
    }

    @Test
    public void testGetGamma() {
        var data = Arrays.asList(new String[]{
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010",
        });
        var array2D = code.convertData(data.stream());
        var result = code.getPowerConsumption(array2D);
        Assertions.assertEquals("10110", result.gammaRate());
        Assertions.assertEquals(22, result.gammaDeciaml());

        Assertions.assertEquals("01001", result.epsilonRate());
        Assertions.assertEquals(9, result.epsilonDecimal());

        Assertions.assertEquals(198, result.epsilonDecimal() * result.gammaDeciaml());
    }

    @Test
    public void testChallenge() {
        var total = code.getPowerConsumption(code.convertData(code.getData()));

        var answer = total.epsilonDecimal() * total.gammaDeciaml();

        Assertions.assertEquals(2972336, answer);
    }

    @Test
    public void testGetSumOfRows() {
        var data = Arrays.asList(new String[]{
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010",
        });
        var array2D = code.convertData(data.stream());
        var result = code.getSumOfRows(array2D, 0);

        Assertions.assertEquals(7, result.get("1"));
        Assertions.assertEquals(5, result.get("0"));

    }
    @Test
    public void testOxygen() {
        var data = Arrays.asList(new String[]{
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010",
        });
        var array2D = code.convertData(data.stream());
        var result = code.getLifeSupport(array2D);

        Assertions.assertEquals(23, result.oxygenDecimal());
        Assertions.assertEquals(10, result.co2Decimal());

        Assertions.assertEquals(230, result.co2Decimal() * result.oxygenDecimal());

    }


    @Test
    public void testChallengePart2() {
        var result = code.getLifeSupport(code.convertData(code.getData()));

        var answer = result.co2Decimal() * result.oxygenDecimal();

        Assertions.assertEquals(3368358, answer);

    }

}
