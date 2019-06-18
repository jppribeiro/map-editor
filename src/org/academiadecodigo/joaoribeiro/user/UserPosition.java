package org.academiadecodigo.joaoribeiro.user;

import org.academiadecodigo.joaoribeiro.grid.Position;

public class UserPosition extends Position {
    // User Position Can Move

    private int cellSize;

    public UserPosition(int cellSize) {
        super(0,0, cellSize);
        this.cellSize = cellSize;
    }

    public void moveUserPosition(Direction direction) {

        // Move logic position
        setCol(getCol() + direction.getMoveCol());
        setRow(getRow() + direction.getMoveRow());

        // Move rectangle
        getCellGfx().translate(cellSize * direction.getMoveCol(), cellSize * direction.getMoveRow());

    }
}
