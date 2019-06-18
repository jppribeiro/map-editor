package org.academiadecodigo.joaoribeiro.user;

import org.academiadecodigo.joaoribeiro.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class User implements KeyboardHandler {

    private UserPosition pos;
    private Grid grid;

    public User(int cellSize, Grid grid) {
        pos = new UserPosition(cellSize);
        pos.getCellGfx().setColor(Color.GREEN);
        this.grid = grid;
    }

    public void init() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

    }

    public void draw() {
        pos.getCellGfx().fill();
    }


    public void keyPressed(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_UP:
                // TODO MOVE UP
                pos.moveUserPosition(Direction.UP);
                break;
            case KeyboardEvent.KEY_RIGHT:
                // TODO MOVE RIGHT
                pos.moveUserPosition(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_DOWN:
                // TODO MOVE DOWN
                pos.moveUserPosition(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                // TODO MOVE LEFT
                pos.moveUserPosition(Direction.LEFT);
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}

