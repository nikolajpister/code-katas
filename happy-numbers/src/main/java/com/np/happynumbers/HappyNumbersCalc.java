package com.np.happynumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HappyNumbersCalc {

    public List<Integer> getHappyNumbersBetween(int start, int end) {
        List<List<Integer>> splittedNumbers = splitNumbersBetween(start, end);
        return getHappyNumbers(splittedNumbers);
    }

    private List<Integer> getHappyNumbers(List<List<Integer>> splittedNumbers) {
        return splittedNumbers.stream().filter(e -> isHappyNumber(e)).map(d -> convertToInteger(d)).collect(Collectors.toList());
    }

    private Integer convertToInteger(List<Integer> digits) {
        String result = digits.stream().map(d -> d.toString()).reduce("", String::concat);
        return Integer.valueOf(result);
    }

    private boolean isHappyNumber(List<Integer> numbers) {
        boolean result = false;

        Integer sum = numbers.stream().map(n -> n * n).reduce(0, Integer::sum);

        if (sum == 1) {
            return true;
        }

        if (sum.toString().length() < 2) {
            return false;
        }

        List<Integer> digits = splitNumber(sum);
        result = isHappyNumber(digits);

        return result;
    }

    private List<List<Integer>> splitNumbersBetween(int start, int end) {
        List<List<Integer>> splittedNumbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<Integer> digits = splitNumber(i);
            splittedNumbers.add(digits);
        }
        return splittedNumbers;
    }

    private List<Integer> splitNumber(int num) {
        List<Integer> digits = new ArrayList<>();
        String number = String.valueOf(num);
        for (int i = 0; i < number.length(); i++) {
            int j = Character.digit(number.charAt(i), 10);
            digits.add(j);
        }

        return digits;
    }
}
