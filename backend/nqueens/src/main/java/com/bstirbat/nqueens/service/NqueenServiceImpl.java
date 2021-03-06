package com.bstirbat.nqueens.service;

import com.bstirbat.nqueens.solver.NqueenSolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NqueenServiceImpl implements NqueenService {

    @Override
    public List<String> solve(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        NqueenSolver nqueenSolver = new NqueenSolver();
        return nqueenSolver.solve(n);
    }
}
