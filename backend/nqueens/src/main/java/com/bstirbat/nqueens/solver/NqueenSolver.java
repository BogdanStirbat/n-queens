package com.bstirbat.nqueens.solver;

import com.bstirbat.nqueens.solver.constraint.*;

import java.util.ArrayList;
import java.util.List;

public class NqueenSolver {

    public List<String> solve(int N) {
        int[][] mat = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                mat[i][j] = 0;
            }
        }

        List<String> solutions = new ArrayList<>();

        List<Constraint> constraints = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        nQueen(solutions, constraints, positions, mat, 0);

        return solutions;
    }

    private void nQueen(List<String> solutions, List<Constraint> constraints, List<Position> positions, int[][] mat, int r) {
        if (r == mat.length) {
            String currentSolution = generateSolution(mat);
            solutions.add(currentSolution);

            return;
        }

        for(int c = 0; c < mat.length; c++) {
            if (isAllowed(constraints, r, c)) {
                Position currentPosition = new Position(r, c);
                List<Constraint> newConstraints = determineNewConstraints(constraints, positions, currentPosition);
                List<Position> newPositions = determineNewPositions(positions, currentPosition);
                mat[r][c] = 1;

                nQueen(solutions, newConstraints, newPositions, mat, r + 1);

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

    private List<Constraint> determineNewConstraints(List<Constraint> constraints, List<Position> positions, Position currentPosition) {
        List<Constraint> newConstraints = new ArrayList<>();
        newConstraints.addAll(constraints);

        newConstraints.add(new SameRowConstraint(currentPosition.r));
        newConstraints.add(new SameColumnConstraint(currentPosition.c));
        newConstraints.add(new SameDiagonalConstraint(currentPosition));
        for(Position position: positions) {
            newConstraints.add(new SameAngleConstraint(position, currentPosition));
        }

        return newConstraints;
    }

    private List<Position> determineNewPositions(List<Position> positions, Position currentPosition) {
        List<Position> newPositions = new ArrayList<>();

        newPositions.addAll(positions);
        newPositions.add(currentPosition);

        return newPositions;
    }

    private String generateSolution(int[][] mat) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                builder.append(mat[i][j]);
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
