package com.bstirbat.nqueens.service;

import com.bstirbat.nqueens.solver.NqueenSolver;
import org.springframework.stereotype.Service;

@Service
public class NqueenServiceImpl implements NqueenService {

    @Override
    public void solve(int n) {

        NqueenSolver nqueenSolver = new NqueenSolver();
        nqueenSolver.solve(n);
    }
}
