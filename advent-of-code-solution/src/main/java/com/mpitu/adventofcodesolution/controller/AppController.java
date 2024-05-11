package com.mpitu.adventofcodesolution.controller;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aoc")
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping(value = "/{year}/{day}")
    public Solution getAnswer(@PathVariable Integer year, @PathVariable Integer day) {
        return appService.getAnswer(year, day);
    }
}
