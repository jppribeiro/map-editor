package org.academiadecodigo.joaoribeiro.grid;

import org.academiadecodigo.joaoribeiro.fileManager.FileManager;
import org.academiadecodigo.joaoribeiro.user.Direction;
import org.academiadecodigo.joaoribeiro.user.User;
import org.academiadecodigo.joaoribeiro.user.UserPosition;

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


    public int getCellSize() {
        return grid.getCellSize();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
