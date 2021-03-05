package com.bstirbat.nqueens.solver.constraint;

import com.bstirbat.nqueens.solver.Position;

public interface Constraint {

    /**
     * A generic constraint for a queen placement on the board.
     * @param p the position
     * @return if current constraint forbids a queen at (r, c) position p
     */
    boolean forbids(Position p);
}
