package org.academiadecodigo.joaoribeiro.user;

public enum Direction {
    UP(0,-1),
    RIGHT(1,0),
    DOWN(0,1),
    LEFT(-1,0);

    private int moveCol;
    private int moveRow;

    Direction(int moveCol, int moveRow) {
        this.moveCol = moveCol;
        this.moveRow = moveRow;
    }

    public int getMoveCol() {
        return moveCol;
    }

    public int getMoveRow() {
        return moveRow;
    }
}
