package com.bstirbat.nqueens.solver;

import com.bstirbat.nqueens.solver.constraint.*;

import java.util.ArrayList;
import java.util.List;

public class NqueenSolver {

    public void solve(int N) {
        int[][] mat = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                mat[i][j] = 0;
            }
        }

        List<Constraint> constraints = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        nQueen(constraints, positions, mat, 0);
    }

    private void nQueen(List<Constraint> constraints, List<Position> positions, int[][] mat, int r) {
        if (r == mat.length) {
            printSolution(mat);
            return;
        }

        for(int c = 0; c < mat.length; c++) {
            if (isAllowed(constraints, r, c)) {
                List<Position> newPositions = determineNewPositions(positions, r, c);
                List<Constraint> newConstraints = determineNewConstraints(newPositions);
                mat[r][c] = 1;

                nQueen(newConstraints, newPositions, mat, r + 1);

                mat[r][c] = 0;
            }
        }
    }

    private boolean isAllowed(List<Constraint> constraints, int r, int c) {
        for(Constraint constraint: constraints) {
            if (constraint.forbids(new Position(r, c))) {
                return false;
            }
        }

        return true;
    }

    private List<Constraint> determineNewConstraints(List<Position> positions) {
        List<Constraint> newConstraints = new ArrayList<>();

        for(int i = 0; i < positions.size(); i++) {
            Position p = positions.get(i);
            newConstraints.add(new SameRowConstraint(p.r));
            newConstraints.add(new SameColumnConstraint(p.c));
            newConstraints.add(new SameDiagonalConstraint(p));
        }

        for(int i = 0; i < positions.size(); i++) {
            for(int j = i + 1; j < positions.size(); j++) {
                newConstraints.add(new SameAngleConstraint(positions.get(i), positions.get(j)));
            }
        }

        return newConstraints;
    }

    private List<Position> determineNewPositions(List<Position> positions, int r, int c) {
        List<Position> newPositions = new ArrayList<>();

        newPositions.addAll(positions);
        newPositions.add(new Position(r, c));

        return newPositions;
    }

    private void printSolution(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
