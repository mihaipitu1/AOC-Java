package com.mpitu.adventofcodesolution.solutions.year_2015.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.List;

public class Day1Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        Integer count = 0;
        for(Character ch : inputLines.getFirst().toCharArray())
            if (ch == '(') {
                count++;
            } else {
                count--;
            }
        return count.toString();
    }

    private String getPartTwo(List<String> inputLines) {
        Integer count = 0;
        char[] inputList = inputLines.getFirst().toCharArray();
        for(Integer i = 0; i < inputList.length; i++) {
            if (inputList[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return String.format("%d",i+1);
            }
        }
        return "-1";
    }
}
