package com.mpitu.adventofcodesolution.solutions.year_2015.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        long goodNumbers = inputLines.stream().map(this::checkString).filter(flag -> flag == 1).count();
        return Long.toString(goodNumbers);
    }

    private String getPartTwo(List<String> inputLines) {
        long goodNumbers = inputLines.stream().map(this::checkStringPartTwo).filter(flag -> flag == 1).count();
        return Long.toString(goodNumbers);
    }

    private Integer checkString(String toBeChecked) {
        List<String> notAllowedStrings = List.of("ab","cd","pq","xy");
        for(String s : notAllowedStrings) {
            if(toBeChecked.contains(s)) {
                return 0;
            }
        }

        Map<Character,Integer> vowelInputMap = new HashMap<>();
        int vowelCount = 0;
        for(Character ch : toBeChecked.toCharArray()) {
            Integer value = vowelInputMap.getOrDefault(ch, 0);
            vowelInputMap.put(ch, value + 1);
        }

        vowelCount = vowelInputMap.keySet().stream()
                .filter(ch -> "aeiou".indexOf(ch) > -1)
                .map(vowelInputMap::get).reduce(0, Integer::sum);

        if (vowelCount < 3) {
            return 0;
        }
        var letters = vowelInputMap.keySet();

        for(Character ch : letters) {
            if(toBeChecked.contains(String.format("%c%c", ch, ch)))
                return 1;
        }

        return 0;
    }

    private Integer checkStringPartTwo(String toBeChecked) {
        int firstRule = 0;
        int secondRule = 0;

        int stringSize = toBeChecked.length();
        for(int i = 0; i < stringSize - 1; i++) {
            String toCheck = toBeChecked.substring(i,i+1);
            if(toBeChecked.substring(i+1).contains(toCheck)) {
                firstRule = 1;
                break;
            }
        }

        for(int i = 0; i < stringSize - 2; i++) {
            if(toBeChecked.charAt(i) == toBeChecked.charAt(i+2) && toBeChecked.charAt(i) != toBeChecked.charAt(i+1)) {
                secondRule = 1;
                break;
            }
        }

        return firstRule * secondRule;
    }
}
