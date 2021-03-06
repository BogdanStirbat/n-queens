package com.bstirbat.nqueens.service;

import com.bstirbat.nqueens.solver.Position;
import com.bstirbat.nqueens.solver.constraint.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NqueenServiceTest {

    private static NqueenService nqueenService;

    @BeforeAll
    public static void setUp() {
        nqueenService = new NqueenServiceImpl();
    }

    @Test
    public void testNegativeSizeBoard() {

        assertTrue(nqueenService.solve(-10).isEmpty());
    }

    @Test
    public void testZeoSizeBoard() {

        assertTrue(nqueenService.solve(0).isEmpty());
    }

    @Test
    public void oneSizeBoard_hasASolution() {

        assertTrue(nqueenService.solve(1).size() == 1);
    }

    @Test
    public void generateAndVerify_AllSolutionsFor_8_Size() {

        List<String> solutions = nqueenService.solve(8);
        for(String solution: solutions) {
            assertTrue(solutionIsValid(solution));
        }
    }

    private boolean solutionIsValid(String solution) {

        List<Constraint> constraints = new ArrayList<>();
        List<Position> positions = new ArrayList<>();

        int i = 0;
        int j = 0;
        for(int k = 0; k < solution.length(); k++) {
            char ch = solution.charAt(k);

            if (ch == '\n') {
                i++;
                j = 0;
                continue;
            }

            if (ch == '0') {
                j++;
                continue;
            }

            if (ch == '1') {
                Position currentPosition = new Position(i, j);

                for(Constraint constraint: constraints) {
                    if (constraint.forbids(currentPosition)) {
                        return false;
                    }
                }

                constraints.add(new SameRowConstraint(i));
                constraints.add(new SameColumnConstraint(j));
                constraints.add(new SameDiagonalConstraint(currentPosition));
                for(Position p: positions) {
                    constraints.add(new SameAngleConstraint(p, currentPosition));
                }

                positions.add(currentPosition);

                j++;
            }
        }

        return true;
    }
}
