package com.bstirbat.nqueens.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NqueenController {

    @GetMapping("/nqeens/{n}")
    public String generateNqeenSolution(@PathVariable("n") Integer n) {

        return "Solution is: " + n;
    }
}
