package org.academiadecodigo.joaoribeiro;

import org.academiadecodigo.joaoribeiro.logicUnit.Grid;
import org.academiadecodigo.joaoribeiro.visualUnit.GridGFX;

public class MapEditor {

    private Grid grid;
    private GridGFX gridGFX;
    private User user;

    public MapEditor(int col, int row, int cellSize) {
        grid = new Grid(col, row, cellSize);
        gridGFX = new GridGFX(col, row, cellSize);
        user = new User(gridGFX);
    }

    public void init() {
        grid.setUser(user);
    }





}
