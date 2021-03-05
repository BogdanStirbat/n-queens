package com.bstirbat.nqueens.controller;

import com.bstirbat.nqueens.service.NqueenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NqueenController {

    private NqueenService nqueenService;

    public NqueenController(NqueenService nqueenService) {
        this.nqueenService = nqueenService;
    }

    @GetMapping("/nqeens/{n}")
    public String generateNqeenSolution(@PathVariable("n") Integer n) {

        nqueenService.solve(n);

        return "Solution is: " + n;
    }
}
