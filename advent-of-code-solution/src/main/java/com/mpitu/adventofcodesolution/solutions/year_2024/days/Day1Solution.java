package com.mpitu.adventofcodesolution.solutions.year_2024.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.*;

public class Day1Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        Long solution = 0L;
        List<Long> leftList = new ArrayList<>();
        List<Long> rightList = new ArrayList<>();

        for(String line : inputLines) {
            String[] split = line.split(" ");
            leftList.add(Long.parseLong(split[0]));
            rightList.add(Long.parseLong(split[3]));
        }

        leftList.sort(Long::compareTo);
        rightList.sort(Long::compareTo);

        for(int i=0;i<leftList.size();i++) {
            solution += Math.abs(leftList.get(i) - rightList.get(i));
        }

        return solution.toString();
    }

    private String getPartTwo(List<String> inputLines) {
        Long solution = 0L;
        List<Long> leftList = new ArrayList<>();
        List<Long> rightList = new ArrayList<>();

        for(String line : inputLines) {
            String[] split = line.split(" ");
            leftList.add(Long.parseLong(split[0]));
            rightList.add(Long.parseLong(split[3]));
        }

        Map<Long, Long> appearance = new HashMap<>();
        leftList.forEach(no -> appearance.put(no, 0L));
        rightList.forEach(no -> appearance.put(no, appearance.getOrDefault(no,0L) + 1L));

        solution = leftList.stream().map(no -> appearance.get(no) * no).reduce(solution, (a, b) -> a + b);

        return solution.toString();
    }


}
