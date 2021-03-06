package com.bstirbat.nqueens.solver.constraint;

import com.bstirbat.nqueens.solver.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SameColumnConstraintTest {

    private static SameColumnConstraint constraint;

    @BeforeAll
    public static void setUp() {
        constraint = new SameColumnConstraint(5);
    }

    @Test
    public void forbidsOnSameColumn() {

        assertTrue(constraint.forbids(new Position(6, 5)));
    }

    @Test
    public void allowsOnDifferentColumn() {

        assertFalse(constraint.forbids(new Position(6, 6)));
    }
}
