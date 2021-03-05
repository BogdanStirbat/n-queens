package com.bstirbat.nqueens.solver.constraint;

import com.bstirbat.nqueens.solver.Position;

public class SameDiagonalConstraint implements Constraint {

    private Position current;

    public SameDiagonalConstraint(Position current) {
        this.current = current;
    }

    @Override
    public boolean forbids(Position p) {

        return (p.r - p.c == current.r - current.c) ||
                (p.r + p.c == current.r + current.c);
    }
}
