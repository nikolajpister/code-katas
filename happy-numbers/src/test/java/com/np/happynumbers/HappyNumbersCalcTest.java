package com.np.happynumbers;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumbersCalcTest {

    @Test
    public void testCalculation() {
        int start = 10;
        int end = 20;
        int[] expectedNumbers = {10, 13, 19};

        List<Integer> result = new HappyNumbersCalc().getHappyNumbersBetween(start, end);

        Assert.assertArrayEquals(expectedNumbers, result.stream().mapToInt(i -> i).toArray());
    }
}
