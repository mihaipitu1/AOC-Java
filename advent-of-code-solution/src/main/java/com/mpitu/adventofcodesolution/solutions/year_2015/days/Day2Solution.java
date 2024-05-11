package com.mpitu.adventofcodesolution.solutions.year_2015.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.Arrays;
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
        Long totalPaper = 0L;
        for(String line : inputLines) {
            var dimensions = Arrays.stream(line.split("x"))
                    .map(Long::parseLong)
                    .toList();
            var areas = List.of(dimensions.get(0)*dimensions.get(1),dimensions.get(1)*dimensions.get(2),dimensions.get(0)*dimensions.get(2));
            var sortedAreas = areas.stream().sorted().toList();
            long area = sortedAreas.get(0);
            area += sortedAreas.stream()
                    .map(number -> 2*number)
                    .reduce(0L, Long::sum);
            totalPaper += area;
        }
        return totalPaper.toString();
    }

    private String getPartTwo(List<String> inputLines) {
        Long totalRibbon = 0L;
        for(String line : inputLines) {
            var dimensions = Arrays.stream(line.split("x"))
                    .map(Long::parseLong)
                    .toList();
            var sortedDimensions = dimensions.stream().sorted().toList();
            long ribbonSize = sortedDimensions.stream().reduce(1L, (a,b) -> a*b);
            ribbonSize += 2 * (sortedDimensions.get(0) + sortedDimensions.get(1));
            totalRibbon += ribbonSize;
        }
        return totalRibbon.toString();
    }
}
