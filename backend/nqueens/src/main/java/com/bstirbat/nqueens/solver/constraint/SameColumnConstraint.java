package com.bstirbat.nqueens.solver.constraint;

import com.bstirbat.nqueens.solver.Position;

public class SameColumnConstraint implements Constraint {

    private int column;

    public SameColumnConstraint(int column) {
        this.column = column;
    }

    @Override
    public boolean forbids(Position p) {
        return this.column == p.c;
    }
}
