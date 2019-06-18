package org.academiadecodigo.joaoribeiro;

import org.academiadecodigo.joaoribeiro.grid.Grid;
import org.academiadecodigo.joaoribeiro.user.User;

public class MapEditor {

    private Grid grid;
    private User user;
    private int cellSize;

    public MapEditor(int col, int row, int cellSize) {
        this.cellSize = cellSize;
        grid = new Grid(col, row, cellSize);
        user = new User(cellSize, grid.getLayout());
    }

    public void init() {

        grid.init(cellSize);

        user.draw();

        grid.drawLayout();

        user.init();

    }





}
