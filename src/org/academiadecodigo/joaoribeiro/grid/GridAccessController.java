package org.academiadecodigo.joaoribeiro.grid;

import org.academiadecodigo.joaoribeiro.fileManager.FileManager;
import org.academiadecodigo.joaoribeiro.user.Direction;
import org.academiadecodigo.joaoribeiro.user.User;
import org.academiadecodigo.joaoribeiro.user.UserPosition;

import java.io.IOException;

public class GridAccessController {

    private Grid grid;
    private User user;
    private FileManager fileManager;

    public GridAccessController(Grid grid) {
        this.grid = grid;
    }

    public boolean checkIfUserInsideGrid(int col, int row) {
        return (col < grid.getLayout().length &&
                row < grid.getLayout()[0].length &&
                col >= 0 &&
                row >= 0);
    }

    public void changeCellStatus(UserPosition pos) {
        grid.getLayout()[pos.getCol()][pos.getRow()].toggleActive();

        if(grid.getLayout()[pos.getCol()][pos.getRow()].isActive()) {
            grid.getLayout()[pos.getCol()][pos.getRow()].fill();
        } else {
            grid.getLayout()[pos.getCol()][pos.getRow()].empty();
        }

    }

    public void checkCellVisibility(UserPosition pos, GridPosition previousPos) {

        GridPosition cellWithUser = grid.getLayout()[pos.getCol()][pos.getRow()];

        GridPosition previousCell = grid.getLayout()[previousPos.getCol()][previousPos.getRow()];

        if ( cellWithUser.isActive() ) {
            cellWithUser.empty();
        }

        if ( previousCell.isActive() ) {
            previousCell.fill();
        }

    }


    // Methods related to Save and Load >>>>>>>>>>>>>>>>>>

    public void save(String filePath) {
        try {
            fileManager.saveStatus(filePath);
        } catch (IOException ioEx) {
            System.out.println("An I/O exception occurred");
        }

    }

    public void load(String filePath) {
        try {
            fileManager.loadStatus(filePath);
        } catch (IOException ioEx) {
            System.out.println("An IO Exception occurred.");
        }
    }


    public void resetCellStatus(int[][] loadedCells) {

        for(int i = 0; i < gridWidth(); i++) {
            for (int j = 0; j < gridHeight(); j++) {
                if(grid.getLayout()[i][j].isActive()) {
                    grid.getLayout()[i][j].toggleActive();
                    grid.getLayout()[i][j].empty();
                    grid.getLayout()[i][j].draw();}
            }
        }

        for (int[] pos:
             loadedCells) {
            GridPosition activeCell = grid.getLayout()[pos[0]][pos[1]];
            if (!activeCell.isActive()) {
                activeCell.toggleActive();
                activeCell.fill();
            }
        }

    }




    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    public int getCellSize() {
        return grid.getCellSize();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public Grid getGrid() {
        return grid;
    }

    public int gridWidth() {
        return grid.getLayout().length;
    }

    public int gridHeight() {
        return grid.getLayout()[0].length;
    }

    public int userColumn() {
        return user.getPos().getCol();
    }

    public int userRow() {
        return user.getPos().getRow();
    }

    public boolean checkIfCellIsActive(int col, int row) {
        return grid.getLayout()[col][row].isActive();
    }

}
