package com.mpitu.adventofcodesolution.solutions.year_2024.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        Long solution = 0L;
        List<String> scanLines = buildAllScans(inputLines);
        Pattern xmasPattern = Pattern.compile("XMAS");
        Pattern samxPattern = Pattern.compile("SAMX");
        for(String line : scanLines) {
            Matcher matcher = xmasPattern.matcher(line);
            while(matcher.find()) {
                solution++;
            }
            Matcher samxMatcher = samxPattern.matcher(line);
            while(samxMatcher.find()) {
                solution++;
            }
        }
        return solution.toString();
    }

    private String getPartTwo(List<String> inputLines) {
        Long solution = 0L;
        int size = inputLines.size();
        char[][] charMatrix = new char[inputLines.size()][inputLines.get(0).length()];

        int index = 0;
        for(String line : inputLines) {
            charMatrix[index] = line.toCharArray();
            index++;
        }

        for(int i = 0; i < size-2; i++) {
            for(int j = 0; j < size-2; j++) {
               char[][] grid = new char[3][3];
               int startRow = i;
               int startCol = j;
               for(int startI = 0; startI < 3; startI++)
                   for(int startJ = 0; startJ < 3; startJ++) {
                       grid[startI][startJ] = charMatrix[startRow + startI][startCol + startJ];
                   }
               char[] firstWord = new char[3];
               char[] secondWord = new char[3];
               for(int k = 0; k < 3; k++) {
                   firstWord[k] = grid[k][k];
                   secondWord[k] = grid[k][2-k];
               }
               String firstWordString = new String(firstWord);
               String secondWordString = new String(secondWord);
               if(checkWord(firstWordString) && checkWord(secondWordString)) {
                   solution++;
               }
            }
        }

        return solution.toString();
    }

    private boolean checkWord(String input) {
        return "MAS".equals(input) || "SAM".equals(input);
    }

    private List<String> buildAllScans(List<String> inputLines) {
        int size = inputLines.size();
        char[][] charMatrix = new char[inputLines.size()][inputLines.get(0).length()];
        char[][] reverseCharMatrix = new char[inputLines.size()][inputLines.get(0).length()];

        int k = 0;
        for(String line : inputLines) {
            charMatrix[k] = line.toCharArray();
            reverseCharMatrix[k] = new StringBuffer(line).reverse().toString().toCharArray();
            k++;
        }
        List<String> scanLines = new ArrayList<>(inputLines);
        for(int i = 0; i < inputLines.size(); i++) {
            char[] toAdd = new char[charMatrix[i].length];
            for(int j = 0; j < charMatrix[i].length; j++) {
                toAdd[j] = charMatrix[j][i];
            }
            scanLines.add(new String(toAdd));
        }
        int maxSum = 2*size - 2;
        for(int sum = 0; sum <= maxSum; sum++) {
            char[] toAdd = new char[maxSum];
            char[] toAddReverse = new char[maxSum];
            int index = 0;
            for(int i =0; i < size; i++) {
                for(int j = 0; j < charMatrix[i].length; j++) {
                    if(i + j == sum) {
                        toAdd[index] = charMatrix[i][j];
                        toAddReverse[index] = reverseCharMatrix[i][j];
                        index++;
                    }
                }
            }
            scanLines.add(new String(toAdd));
            scanLines.add(new String(toAddReverse));
        }
        return scanLines;
    }
}
