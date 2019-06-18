package org.academiadecodigo.joaoribeiro.grid;

public class GridPosition extends Position {

    public GridPosition(int col, int row, int cellSize) {
        super(col, row, cellSize);
    }

    public void setCanvas() {
        getCellGfx().draw();
    }

    public void fill() {
        getCellGfx().fill();
    }

    public void empty() {
        getCellGfx().delete();
        getCellGfx().draw();
    }

}
