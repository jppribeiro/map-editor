package org.academiadecodigo.joaoribeiro;

import org.academiadecodigo.joaoribeiro.fileManager.FileManager;
import org.academiadecodigo.joaoribeiro.grid.Grid;
import org.academiadecodigo.joaoribeiro.grid.GridAccessController;
import org.academiadecodigo.joaoribeiro.user.User;

public class MapEditor {

    private Grid grid;
    private GridAccessController gridController;
    private User user;
    private FileManager fileManager;

    public MapEditor(int col, int row, int cellSize) {
        grid = new Grid(col, row, cellSize);
        gridController = new GridAccessController(grid);
        user = new User(cellSize, gridController);
        gridController.setUser(user);
        fileManager = new FileManager(gridController);
    }

    public void init() {

        grid.init();

        user.draw();

        grid.drawLayout();

        user.init();

    }





}
