package com.bstirbat.nqueens.solver.constraint;


import com.bstirbat.nqueens.solver.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SameRowConstraintTest {

    private static SameRowConstraint constraint;

    @BeforeAll
    public static void setUp() {
        constraint = new SameRowConstraint(5);
    }

    @Test
    public void forbidsOnSameRow() {

        assertTrue(constraint.forbids(new Position(5, 8)));
    }

    @Test
    public void allowsOnDifferentRow() {

        assertFalse(constraint.forbids(new Position(6, 8)));
    }
}
