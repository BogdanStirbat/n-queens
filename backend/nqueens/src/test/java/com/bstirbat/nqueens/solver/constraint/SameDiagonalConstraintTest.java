package com.bstirbat.nqueens.solver.constraint;

import com.bstirbat.nqueens.solver.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SameDiagonalConstraintTest {

    private static SameDiagonalConstraint constraint;

    @BeforeAll
    public static void setUp() {
        constraint = new SameDiagonalConstraint(new Position(3, 5));
    }

    @Test
    public void leftUpDiagonalsForbidden() {

        assertTrue(constraint.forbids(new Position(2, 4)));
        assertTrue(constraint.forbids(new Position(1, 3)));
        assertTrue(constraint.forbids(new Position(0, 2)));
    }

    @Test
    public void rightUpDiagonalsForbidden() {

        assertTrue(constraint.forbids(new Position(2, 6)));
        assertTrue(constraint.forbids(new Position(1, 7)));
        assertTrue(constraint.forbids(new Position(0, 8)));
    }

    @Test
    public void leftDownDiagonalsForbidden() {

        assertTrue(constraint.forbids(new Position(4, 4)));
        assertTrue(constraint.forbids(new Position(5, 3)));
        assertTrue(constraint.forbids(new Position(6, 2)));
        assertTrue(constraint.forbids(new Position(7, 1)));
        assertTrue(constraint.forbids(new Position(8, 0)));
    }

    @Test
    public void rightDownDiagonalsForbidden() {

        assertTrue(constraint.forbids(new Position(4, 6)));
        assertTrue(constraint.forbids(new Position(5, 7)));
        assertTrue(constraint.forbids(new Position(6, 8)));
    }

    @Test
    public void positionNotOnDiagonalAllowed() {

        assertFalse(constraint.forbids(new Position(0, 0)));
    }
}
