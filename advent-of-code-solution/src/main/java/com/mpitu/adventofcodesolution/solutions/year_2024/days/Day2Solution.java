package com.mpitu.adventofcodesolution.solutions.year_2024.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.ArrayList;
import java.util.List;

public class Day2Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        Long solution = 0L;

        for(String line : inputLines) {
            List<Long> numbers = new ArrayList<>();
            String[] splitList = line.split(" ");
            for(String s : splitList) {
                numbers.add(Long.parseLong(s));
            }
            solution += checkRules(numbers) ? 1 : 0;
        }
        return solution.toString();
    }

    private String getPartTwo(List<String> inputLines) {
        Long solution = 0L;

        for(String line : inputLines) {
            List<Long> numbers = new ArrayList<>();
            String[] splitList = line.split(" ");
            for(String s : splitList) {
                numbers.add(Long.parseLong(s));
            }
            solution += checkRulesPartTwo(numbers) ? 1 : 0;
        }
        return solution.toString();
    }

    private boolean checkRules(List<Long> inputNumbers) {
        boolean descend = false;
        long checkDiff = inputNumbers.get(1) - inputNumbers.get(0);
        if(checkDiff < 0) descend = true;
        for(int i=0; i<inputNumbers.size()-1; i++) {
            long first = inputNumbers.get(i);
            long second = inputNumbers.get(i+1);
            checkDiff = first - second;
            if(Math.abs(checkDiff) == 0  || Math.abs(checkDiff) > 3)
                return false;
            if(descend) {
                if(first < second)
                    return false;
            } else {
                if(first > second)
                    return false;
            }
        }
        return true;
    }


    private boolean checkRulesPartTwo(List<Long> inputNumbers) {
        if(checkRules(inputNumbers)) {
            return true;
        } else {
            for(int i=0; i<inputNumbers.size(); i++) {
                List<Long> numbers = new ArrayList<>();
                for(int j=0; j<i;j++) {
                    numbers.add(inputNumbers.get(j));
                }
                for(int j=i+1; j<inputNumbers.size(); j++) {
                    numbers.add(inputNumbers.get(j));
                }
                if(checkRules(numbers)) {
                    return true;
                }
            }
            return false;
        }
    }
}
