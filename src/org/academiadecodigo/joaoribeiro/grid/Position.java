package org.academiadecodigo.joaoribeiro.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Position {

    private int col;
    private int row;
    private final int PADDING;
    private Rectangle cellGfx;

    public Position(int col, int row, int cellSize) {
        this.col = col;
        this.row = row;
        PADDING = 10;
        cellGfx = new Rectangle(col * cellSize + PADDING, row * cellSize + PADDING, cellSize, cellSize);
    }

    public void draw() {
        cellGfx.draw();
    }

    public void fill() {
        cellGfx.fill();
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

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Rectangle getCellGfx() {
        return cellGfx;
    }

    public void setCellGfx(Rectangle cellGfx) {
        this.cellGfx = cellGfx;
    }
}

