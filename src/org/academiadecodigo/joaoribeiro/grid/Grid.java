package org.academiadecodigo.joaoribeiro.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Position[][] layout;
    private final int PADDING;


    public Grid(int colNum, int rowNum, int cellSize) {
        PADDING = 10;
        layout = new Position[colNum][rowNum];
        buildGrid(colNum, rowNum, cellSize);
        init(cellSize);
    }

    // METHODS TO CONSTRUCT THE GRID >>>>>>>>>>>>

    private void buildGrid(int colNum, int rowNum, int cellSize) {
        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                layout[i][j] = new GridPosition(i, j, cellSize);
            }
        }
    }

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    public void init(int cellSize) {
        Rectangle window = new Rectangle(PADDING, PADDING, cellSize, cellSize);
        window.draw();
    }

    public void drawLayout() {
        for (Position[] col:
                layout) {
            for (Position pos:
                    col) {
                pos.getCellGfx().draw();
            }
        }
    }


    public Position[][] getLayout() {
        return layout;
    }
}
