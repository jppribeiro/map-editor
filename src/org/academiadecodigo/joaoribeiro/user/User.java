package org.academiadecodigo.joaoribeiro.user;

import org.academiadecodigo.joaoribeiro.grid.GridAccessController;
import org.academiadecodigo.joaoribeiro.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class User implements KeyboardHandler {

    private UserPosition pos;
    private GridPosition previousPos;
    private GridAccessController gridController;

    public User(int cellSize, GridAccessController gridController) {
        pos = new UserPosition(cellSize);
        pos.getCellGfx().setColor(Color.GREEN);
        this.gridController = gridController;
    }

    public void init() {

        Keyboard keyboard = new Keyboard(this);

        initKeyboardEventPress(keyboard, KeyboardEvent.KEY_UP);
        initKeyboardEventPress(keyboard, KeyboardEvent.KEY_RIGHT);
        initKeyboardEventPress(keyboard, KeyboardEvent.KEY_DOWN);
        initKeyboardEventPress(keyboard, KeyboardEvent.KEY_LEFT);
        initKeyboardEventPress(keyboard, KeyboardEvent.KEY_SPACE);
        initKeyboardEventRelease(keyboard, KeyboardEvent.KEY_SPACE);

    }


    public void initKeyboardEventPress(Keyboard keyboard, int key) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);
    }

    public void initKeyboardEventRelease(Keyboard keyboard, int key) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event);
    }

    public void draw() {
        pos.getCellGfx().fill();
    }


    public void keyPressed(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_UP:
                // TODO MOVE UP
                moveUser(Direction.UP);
                break;
            case KeyboardEvent.KEY_RIGHT:
                // TODO MOVE RIGHT
                moveUser(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_DOWN:
                // TODO MOVE DOWN
                moveUser(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                // TODO MOVE LEFT
                moveUser(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_SPACE:
                pos.getCellGfx().setColor(Color.BLUE);
                gridController.changeCellStatus(pos);
                gridController.checkCellVisibility(pos, previousPos);
            default:
                break;
        }
    }

    private void moveUser(Direction dir) {

        previousPos = new GridPosition(pos.getCol(), pos.getRow(), gridController.getCellSize());

        if(gridController.checkIfUserInsideGrid(pos.getCol() + dir.getMoveCol(), pos.getRow() + dir.getMoveRow())) {
            pos.moveUserPosition(dir);
        }

        gridController.checkCellVisibility(pos, previousPos);

    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_SPACE:
                pos.getCellGfx().setColor(Color.GREEN);
            default:
                break;
        }
    }


}

