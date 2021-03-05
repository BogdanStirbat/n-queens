package com.bstirbat.nqueens.solver.constraint;

import com.bstirbat.nqueens.solver.Position;

/**
 * Checks if chess position given as argument forms an angle, at any angle
 * For example: A1, C2, E3 are on an angle.
 *
 * Positions P1 (r1, c1), P2 (r2, c2), P3 (r3, c3) form an angle if and only if both conditions are true:
 * 1. r1 <= r2 <= r3; r2 - r1 == r3 - r2
 * 2. c1 <= c2 <= c3; c2 - c1 == c3 - c2
 */
public class SameAngleConstraint implements Constraint {

    private Position p1;
    private Position p2;

    public SameAngleConstraint(Position p1, Position p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // Checks all possible ways P1 (r1, c1), P2 (r2, c2), P (r, c) forms an angle (see definition above)
    @Override
    public boolean forbids(Position p) {
        return formsAnAngle(p1, p2, p) ||
                formsAnAngle(p2, p1, p) ||
                formsAnAngle(p1, p, p2) ||
                formsAnAngle(p2, p, p1) ||
                formsAnAngle(p, p1, p2) ||
                formsAnAngle(p, p2, p1);
    }

    // Checks if P1 (r1, c1), P2 (r2, c2), P3 (r3, c3) form an angle.
    // See above for the formal condition
    private boolean formsAnAngle(Position p1, Position p2, Position p3) {
        return (p1.r <= p2.r && p2.r <= p3.r && p2.r - p1.r == p3.r - p2.r) &&
                (p1.c <= p2.c && p2.c <= p3.c && p2.c - p1.c == p3.c - p2.c);
    }
}
