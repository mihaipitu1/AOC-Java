package com.mpitu.adventofcodesolution.solutions.year_2015;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.solutions.year_2015.days.Day1Solution;
import com.mpitu.adventofcodesolution.solutions.year_2015.days.Day2Solution;
import com.mpitu.adventofcodesolution.solutions.year_2015.days.Day3Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.util.List;

public class SolutionDelegate2015 {

    public static Solution getAnswer(int day, List<String> inputStrings) {
        ISolution solution;
        switch(day) {
            case 1: solution = new Day1Solution();
                    break;
            case 2: solution = new Day2Solution();
                break;
            case 3: solution = new Day3Solution();
                break;
            case 4: solution = new Day1Solution();
                break;
            case 5: solution = new Day1Solution();
                break;
            case 6: solution = new Day1Solution();
                break;
            case 7: solution = new Day1Solution();
                break;
            case 8: solution = new Day1Solution();
                break;
            case 9: solution = new Day1Solution();
                break;
            case 10: solution = new Day1Solution();
                break;
            case 11: solution = new Day1Solution();
                break;

            default: return Solution.builder().build();
        }
        return solution.getAnswer(inputStrings);
    }
}
