package com.mpitu.adventofcodesolution.service;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.solutions.year_2015.SolutionDelegate2015;
import com.mpitu.adventofcodesolution.solutions.year_2016.SolutionDelegate2016;
import com.mpitu.adventofcodesolution.util.FileHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    public Solution getAnswer(Integer year, Integer day) {
        List<String> parsedLines = FileHandler.readInputLines(year, day);

        switch(year) {
            case 2015: return SolutionDelegate2015.getAnswer(day, parsedLines);
            case 2016: return SolutionDelegate2016.getAnswer(day, parsedLines);
            default: return Solution.builder().build();
        }
    }
}
