package org.academiadecodigo.joaoribeiro.logicUnit;

public class GridPosition extends Position {

    public GridPosition(int col, int row) {
        super(col, row);
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
