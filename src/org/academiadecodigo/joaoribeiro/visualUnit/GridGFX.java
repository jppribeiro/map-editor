package org.academiadecodigo.joaoribeiro.visualUnit;

import org.academiadecodigo.joaoribeiro.logicUnit.Position;
import org.academiadecodigo.joaoribeiro.logicUnit.Grid;
import org.academiadecodigo.joaoribeiro.logicUnit.user.UserPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridGFX {

    private int cellSize;
    private final int PADDING;

    public GridGFX(int colNum, int rowNum, int cellSize) {
        this.cellSize = cellSize;
        PADDING = 10;
        drawWindow(colNum, rowNum);
    }

    private void drawWindow(int colNum, int rowNum) {
        Rectangle window = new Rectangle(PADDING, PADDING, colNum * cellSize, rowNum * cellSize);
        window.draw();
    }

    public void drawLayout(Position[][] layout) {
        for (Position[] col:
                layout) {
            for (Position pos:
                    col) {
                pos.setCellGfx(new Rectangle(pos.getCol() * cellSize + PADDING, pos.getRow() * cellSize + PADDING, cellSize, cellSize));
                pos.getCellGfx().draw();
            }
        }
    }

    public void drawUser(UserPosition pos) {

        pos.setCellGfx(new Rectangle(pos.getCol() * cellSize + PADDING, pos.getRow() * cellSize + PADDING, cellSize, cellSize));
        pos.getCellGfx().fill();

    }




}
