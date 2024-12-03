package com.mpitu.adventofcodesolution.solutions.year_2024.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        Long solution = 0L;
        Pattern muxPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        for (String line : inputLines) {
            Matcher matcher = muxPattern.matcher(line);
            while (matcher.find()) {
                String matched = matcher.group();
                solution += getMulResult(matched, true);
            }
        }
        return solution.toString();
    }

    private String getPartTwo(List<String> inputLines) {
        Long solution = 0L;
        boolean isEnabled = true;
        Pattern muxPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");
        for (String line : inputLines) {
            Matcher matcher = muxPattern.matcher(line);
            while (matcher.find()) {
                String matched = matcher.group();
                switch(matched) {
                    case "do()": isEnabled = true; break;
                    case "don't()": isEnabled = false; break;
                    default: solution += getMulResult(matched, isEnabled); break;
                }
            }
        }
        return solution.toString();
    }

    private Long getMulResult(String matched, boolean isEnabled) {
        Long toAdd = 1L;
        Pattern digitRegex = Pattern.compile("\\d+");
        Matcher digitMatcher = digitRegex.matcher(matched);
        while(digitMatcher.find()) {
            toAdd *= Long.parseLong(digitMatcher.group());
        }
        return isEnabled ? toAdd : 0L;
    }
}
