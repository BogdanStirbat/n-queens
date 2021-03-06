package com.bstirbat.nqueens.solver.constraint;


import com.bstirbat.nqueens.solver.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SameAngleConstraintTest {

    @Test
    public void leftDownAnglesForbidden() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(7, 4), new Position(6, 6));
        assertTrue(constraint.forbids(new Position(8, 2)));
        assertTrue(constraint.forbids(new Position(9, 0)));
    }

    @Test
    public void leftDown_FarAway_DifferentAngle_Forbidden() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(3, 7), new Position(1, 10));
        assertTrue(constraint.forbids(new Position(7, 1)));
    }

    @Test
    public void rightUpAnglesForbidden() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(7, 4), new Position(6, 6));
        assertTrue(constraint.forbids(new Position(5, 8)));
        assertTrue(constraint.forbids(new Position(4, 10)));
    }

    @Test
    public void rightUp_FarAway_DifferentAngle_Forbidden() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(7, 1), new Position(5, 4));
        assertTrue(constraint.forbids(new Position(1, 10)));
    }

    @Test
    public void leftUpAnglesForbidden() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(4, 4), new Position(6, 5));
        assertTrue(constraint.forbids(new Position(2, 3)));
        assertTrue(constraint.forbids(new Position(0, 2)));
    }

    @Test
    public void leftUp_FarAway_DifferentAngle_Forbidden() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(7, 5), new Position(10, 7));
        assertTrue(constraint.forbids(new Position(1, 1)));
    }

    @Test
    public void rightDownAnglesForbidden() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(4, 4), new Position(6, 5));
        assertTrue(constraint.forbids(new Position(8, 6)));
        assertTrue(constraint.forbids(new Position(10, 7)));
    }

    @Test
    public void rightDown_FarAway_DifferentAngle_Forbidden() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(1, 1), new Position(4, 3));
        assertTrue(constraint.forbids(new Position(10, 7)));
    }

    @Test
    public void allowsOnDifferentAngle() {

        SameAngleConstraint constraint = new SameAngleConstraint(new Position(7, 4), new Position(6, 6));
        assertFalse(constraint.forbids(new Position(1, 1)));
    }
}
