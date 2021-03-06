package com.bstirbat.nqueens.solver.constraint;

import com.bstirbat.nqueens.solver.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Checks if chess position given as argument forms an angle, at any angle
 * For example: A1, C2, E3 are on an angle.
 *
 * Positions P1 (r1, c1), P2 (r2, c2), P3 (r3, c3), r1 < r2 < r3,  form an angle if and only if:
 * (c2 - c1) * (r3 - r2) = (r2 - r1) * (c3 - c2)
 */
public class SameAngleConstraint implements Constraint {

    private Position p1;
    private Position p2;

    public SameAngleConstraint(Position p1, Position p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // Checks if P1 (r1, c1), P2 (r2, c2), P (r, c) forms an angle (see definition above)
    @Override
    public boolean forbids(Position p) {
        List<Position> positions = new ArrayList<>();
        positions.add(p1);
        positions.add(p2);
        positions.add(p);

        Collections.sort(positions, Comparator.comparingInt(sp -> sp.r));

        Position sp1 = positions.get(0);
        Position sp2 = positions.get(1);
        Position sp3 = positions.get(2);

        return (sp2.c - sp1.c) * (sp3.r - sp2.r) == (sp2.r - sp1.r) * (sp3.c - sp2.c);
    }
}
