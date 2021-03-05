package com.bstirbat.nqueens.solver;

/**
 * Represents a position on the chess board.
 * r is the raw, c is the column.
 */
public class Position {
    public final int r;
    public final int c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
