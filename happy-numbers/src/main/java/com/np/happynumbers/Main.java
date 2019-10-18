package com.np.happynumbers;

import java.util.List;

public class Main {

    private static final Integer START = 10;
    private static final Integer END = 20;

    public static void main(String[] args) {
        System.out.println("happy numbers between " + START + " and " + END);
        List<Integer> result = new HappyNumbersCalc().getHappyNumbersBetween(START, END);
        result.stream().forEach(System.out::println);
    }


}
