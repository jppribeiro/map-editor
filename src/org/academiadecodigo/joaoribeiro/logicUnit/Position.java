package org.academiadecodigo.joaoribeiro.logicUnit;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Position {

    private int col;
    private int row;
    private Rectangle cellGfx;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }


    public boolean equals(Position pos) {
        return (this.col == pos.col && this.row == pos.row);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Rectangle getCellGfx() {
        return cellGfx;
    }

    public void setCellGfx(Rectangle cellGfx) {
        this.cellGfx = cellGfx;
    }
}

