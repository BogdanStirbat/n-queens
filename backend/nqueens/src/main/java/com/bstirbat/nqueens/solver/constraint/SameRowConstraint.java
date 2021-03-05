package com.bstirbat.nqueens.solver.constraint;

import com.bstirbat.nqueens.solver.Position;

public class SameRowConstraint implements Constraint {

    private int raw;

    public SameRowConstraint(int raw) {
        this.raw = raw;
    }

    @Override
    public boolean forbids(Position p) {
        return this.raw == p.r;
    }
}
