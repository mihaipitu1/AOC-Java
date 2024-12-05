package com.mpitu.adventofcodesolution.solutions.year_2024.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.*;

public class Day5Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        Long solution = 0L;
        Map<Integer, List<Integer>> pageOrderMap = new HashMap<>();
        List<String> updateLines = new ArrayList<>();
        for(String line : inputLines) {
            if(line.contains("|")) {
                String[] lineSplit = line.split("\\|");
                Integer key = Integer.parseInt(lineSplit[0]);
                Integer value = Integer.parseInt(lineSplit[1]);
                List<Integer> values = pageOrderMap.getOrDefault(key, new ArrayList<>());
                values.add(value);
                pageOrderMap.put(key,values);
            } else if(!line.isEmpty()) {
                updateLines.add(line);
            }
        }

        for(String line : updateLines) {
            List<Integer> integerList = Arrays.stream(line.split(","))
                    .map(Integer::parseInt).toList();
            boolean isValid = true;
            for (int i = 0; i < integerList.size(); i++) {
                List<Integer> afterList = pageOrderMap.getOrDefault(i, new ArrayList<>());
                for (int j = i + 1; j < integerList.size(); j++) {
                    int toCheck = integerList.get(j);
                    if (!afterList.contains(toCheck)) {
                        List<Integer> beforeList = pageOrderMap.getOrDefault(toCheck, new ArrayList<>());
                        for (int k = 0; k <= i; k++) {
                            if (beforeList.contains(integerList.get(k))) {
                                isValid = false;
                                break;
                            }
                        }
                    }
                    if(!isValid) {
                        break;
                    }
                }
            }
            if (isValid) {
                int size = integerList.size();
                solution += integerList.get(size / 2);
            }
        }

        return solution.toString();
    }

    private String getPartTwo(List<String> inputLines) {
        Long solution = 0L;
        Map<Integer, List<Integer>> pageOrderMap = new HashMap<>();
        List<String> updateLines = new ArrayList<>();
        for(String line : inputLines) {
            if(line.contains("|")) {
                String[] lineSplit = line.split("\\|");
                Integer key = Integer.parseInt(lineSplit[0]);
                Integer value = Integer.parseInt(lineSplit[1]);
                List<Integer> values = pageOrderMap.getOrDefault(key, new ArrayList<>());
                values.add(value);
                pageOrderMap.put(key,values);
            } else if(!line.isEmpty()) {
                updateLines.add(line);
            }
        }

        List<List<Integer>> incorrectPrints = new ArrayList<>();
        for(String line : updateLines) {
            List<Integer> integerList = Arrays.stream(line.split(","))
                    .map(Integer::parseInt).toList();
            boolean isValid = true;
            for (int i = 0; i < integerList.size(); i++) {
                List<Integer> afterList = pageOrderMap.getOrDefault(i, new ArrayList<>());
                for (int j = i + 1; j < integerList.size(); j++) {
                    int toCheck = integerList.get(j);
                    if (!afterList.contains(toCheck)) {
                        List<Integer> beforeList = pageOrderMap.getOrDefault(toCheck, new ArrayList<>());
                        for (int k = 0; k <= i; k++) {
                            if (beforeList.contains(integerList.get(k))) {
                                isValid = false;
                                break;
                            }
                        }
                    }
                }
            }
            if(!isValid) {
                incorrectPrints.add(integerList);
            }
        }

        // TODO: check here for lower value
        for(List<Integer> incorrectList : incorrectPrints) {
            int size = incorrectList.size();
            int temp;
            int[] incorrectArray = incorrectList.stream().mapToInt(x->x).toArray();
            boolean isChanged;
            for(int i = 0; i<size-1;i++) {
                isChanged = false;
                for(int j=0;j<size-i-1;j++) {
                    List<Integer> ruleList = pageOrderMap.getOrDefault(i, new ArrayList<>());
                    if(ruleList.contains(incorrectArray[j])) {
                        temp = incorrectArray[j];
                        incorrectArray[j] = incorrectArray[i];
                        incorrectArray[i] = temp;
                        isChanged = true;
                    }
                }
                if(!isChanged)
                    break;
            }
            solution += incorrectArray[size / 2];
        }
        return solution.toString();
    }
}
