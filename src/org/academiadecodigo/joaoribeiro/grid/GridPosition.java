package org.academiadecodigo.joaoribeiro.grid;

public class GridPosition extends Position {

    private boolean active;

    public GridPosition(int col, int row, int cellSize) {
        super(col, row, cellSize);
        active = false;
    }

    public void setCanvas() {
        getCellGfx().draw();
    }

    public void fill() {
        getCellGfx().delete();
        getCellGfx().fill();
    }

    public void empty() {
        getCellGfx().delete();
        getCellGfx().draw();
    }

    public boolean isActive() {
        return active;
    }

    public void toggleActive() {
        if(active) {
            active = false;
        } else {
            active = true;
        }
    }
}
