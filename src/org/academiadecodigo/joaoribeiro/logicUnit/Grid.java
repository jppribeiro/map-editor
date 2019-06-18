package org.academiadecodigo.joaoribeiro.logicUnit;

import org.academiadecodigo.joaoribeiro.visualUnit.GridGFX;

public class Grid {

    private Position[][] layout;
    private GridGFX gridGFX;

    public Grid(int colNum, int rowNum, int cellSize) {
        layout = new Position[colNum][rowNum];
        buildGrid(colNum, rowNum);
        gridGFX = new GridGFX(colNum, rowNum, cellSize);
        gridGFX.drawLayout(layout);
    }

    // METHODS TO CONSTRUCT THE GRID >>>>>>>>>>>>

    private void buildGrid(int colNum, int rowNum) {
        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                layout[i][j] = new GridPosition(i, j);
            }
        }
    }



    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



    public Position[][] getLayout() {
        return layout;
    }
}
