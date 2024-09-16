package com.mpitu.adventofcodesolution.solutions.year_2015.days;

import com.mpitu.adventofcodesolution.model.Point2D;
import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day3Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        var houseMap = getHouseGridMap();
        Point2D startingPoint = houseMap.keySet().iterator().next();
        int row = 0;
        int col = 0;
        for(Character ch : inputLines.get(0).toCharArray()) {
            switch(ch) {
                case '^':
                    row--;
                    break;
                case '>':
                    col++;
                    break;
                case '<':
                    col--;
                    break;
                case 'v':
                    row++;
                    break;
                default: break;
            }
            Point2D key = checkExistingKey(row, col, houseMap.keySet());
            if (key == null) {
                houseMap.put(Point2D.builder().row(row).col(col).build(), 1);
            } else {
                houseMap.put(key, houseMap.get(key) + 1);
            }
        }
        return String.format("%d",houseMap.keySet().size());
    }

    private String getPartTwo(List<String> inputLines) {
        var houseMap = getHouseGridMap();
        Point2D startingPoint = houseMap.keySet().iterator().next();
        int row = 0;
        int col = 0;
        int rowRobo = 0;
        int colRobo = 0;
        char[] instructionsList = inputLines.get(0).toCharArray();
        for(int i = 0; i < instructionsList.length; i++) {
            Character ch = instructionsList[i];
            if (i % 2 == 0) {
                switch (ch) {
                    case '^':
                        row--;
                        break;
                    case '>':
                        col++;
                        break;
                    case '<':
                        col--;
                        break;
                    case 'v':
                        row++;
                        break;
                    default:
                        break;
                }
                Point2D key = checkExistingKey(row, col, houseMap.keySet());
                if (key == null) {
                    houseMap.put(Point2D.builder().row(row).col(col).build(), 1);
                } else {
                    houseMap.put(key, houseMap.get(key) + 1);
                }
            } else {
                switch (ch) {
                    case '^':
                        rowRobo--;
                        break;
                    case '>':
                        colRobo++;
                        break;
                    case '<':
                        colRobo--;
                        break;
                    case 'v':
                        rowRobo++;
                        break;
                    default:
                        break;
                }
                Point2D key = checkExistingKey(rowRobo, colRobo, houseMap.keySet());
                if (key == null) {
                    houseMap.put(Point2D.builder().row(rowRobo).col(colRobo).build(), 1);
                } else {
                    houseMap.put(key, houseMap.get(key) + 1);
                }
            }
        }
        return String.format("%d",houseMap.keySet().size());
    }

    private Map<Point2D, Integer> getHouseGridMap() {
        Map<Point2D, Integer> houseMap = new HashMap<>();
        Point2D startingPoint = Point2D.builder()
                .row(0)
                .col(0)
                .build();
        houseMap.put(startingPoint, 0);
        return houseMap;
    }

    private Point2D checkExistingKey(int row, int col, Set<Point2D> keySet) {
        for(Point2D key : keySet) {
            if( row == key.getRow() && col == key.getCol())
                return key;
        }
        return null;
    }
}
