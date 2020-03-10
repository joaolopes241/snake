package org.academiadecodigo.ramsters43.snake.gfx.simplegfx;

import org.academiadecodigo.ramsters43.snake.Game;
import org.academiadecodigo.ramsters43.snake.field.FieldDirection;
import org.academiadecodigo.ramsters43.snake.gamecontrols.GameControls;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.ramsters43.snake.snake.Snake;

public class SimpleGfxGameControls implements GameControls, KeyboardHandler {

    private Keyboard keyboard;
    private Snake snake;
    private Game game;

    public SimpleGfxGameControls(Snake snake, Game game) {

        keyboard = new Keyboard(this);

        this.snake = snake;
        this.game = game;
    }

    @Override
    public void init() {

        setGoRightEvents();

        setGoLeftEvents();

        setGoUpEvents();

        setGoDownEvents();

        setStartEvent();

        setPauseEvent();
    }


    @Override
    public void keyPressed(KeyboardEvent event) {

        if (event.getKey() == KeyboardEvent.KEY_RIGHT || event.getKey() == KeyboardEvent.KEY_L ||
                event.getKey() == KeyboardEvent.KEY_D) {

            snake.getSnakeHead().changeCurrentFieldDirection(FieldDirection.RIGHT, snake);
        }

        if (event.getKey() == KeyboardEvent.KEY_LEFT || event.getKey() == KeyboardEvent.KEY_J ||
                event.getKey() == KeyboardEvent.KEY_A) {

            snake.getSnakeHead().changeCurrentFieldDirection(FieldDirection.LEFT, snake);
        }

        if (event.getKey() == KeyboardEvent.KEY_UP || event.getKey() == KeyboardEvent.KEY_I ||
                event.getKey() == KeyboardEvent.KEY_W) {

            snake.getSnakeHead().changeCurrentFieldDirection(FieldDirection.UP, snake);
        }

        if (event.getKey() == KeyboardEvent.KEY_DOWN || event.getKey() == KeyboardEvent.KEY_K ||
                event.getKey() == KeyboardEvent.KEY_S) {

            snake.getSnakeHead().changeCurrentFieldDirection(FieldDirection.DOWN, snake);
        }

        if (event.getKey() == KeyboardEvent.KEY_ENTER) {

            game.setOnPlay();
        }

        if (event.getKey() == KeyboardEvent.KEY_P) {

            game.setOnPause();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent event) {

    }

    @Override
    public void setGoRightEvents() {

        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        KeyboardEvent rightKeyPressed1 = new KeyboardEvent();
        KeyboardEvent rightKeyPressed2 = new KeyboardEvent();

        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyPressed1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyPressed2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightKeyPressed1.setKey(KeyboardEvent.KEY_L);
        rightKeyPressed2.setKey(KeyboardEvent.KEY_D);

        keyboard.addEventListener(rightKeyPressed);
        keyboard.addEventListener(rightKeyPressed1);
        keyboard.addEventListener(rightKeyPressed2);
    }

    @Override
    public void setGoLeftEvents() {

        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        KeyboardEvent leftKeyPressed1 = new KeyboardEvent();
        KeyboardEvent leftKeyPressed2 = new KeyboardEvent();

        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyPressed1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyPressed2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftKeyPressed1.setKey(KeyboardEvent.KEY_J);
        leftKeyPressed2.setKey(KeyboardEvent.KEY_A);

        keyboard.addEventListener(leftKeyPressed);
        keyboard.addEventListener(leftKeyPressed1);
        keyboard.addEventListener(leftKeyPressed2);
    }

    @Override
    public void setGoUpEvents() {

        KeyboardEvent upKeyPressed = new KeyboardEvent();
        KeyboardEvent upKeyPressed1 = new KeyboardEvent();
        KeyboardEvent upKeyPressed2 = new KeyboardEvent();

        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyPressed1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyPressed2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        upKeyPressed.setKey(KeyboardEvent.KEY_UP);
        upKeyPressed1.setKey(KeyboardEvent.KEY_I);
        upKeyPressed2.setKey(KeyboardEvent.KEY_W);

        keyboard.addEventListener(upKeyPressed);
        keyboard.addEventListener(upKeyPressed1);
        keyboard.addEventListener(upKeyPressed2);
    }

    @Override
    public void setGoDownEvents() {

        KeyboardEvent downKeyPressed = new KeyboardEvent();
        KeyboardEvent downKeyPressed1 = new KeyboardEvent();
        KeyboardEvent downKeyPressed2 = new KeyboardEvent();

        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyPressed1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyPressed2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);
        downKeyPressed1.setKey(KeyboardEvent.KEY_K);
        downKeyPressed2.setKey(KeyboardEvent.KEY_S);

        keyboard.addEventListener(downKeyPressed);
        keyboard.addEventListener(downKeyPressed1);
        keyboard.addEventListener(downKeyPressed2);
    }

    @Override
    public void setStartEvent() {

        KeyboardEvent startKeyPressed = new KeyboardEvent();
        startKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        startKeyPressed.setKey(KeyboardEvent.KEY_ENTER);
        keyboard.addEventListener(startKeyPressed);
    }

    @Override
    public void setPauseEvent() {

        KeyboardEvent pauseKeyPressed = new KeyboardEvent();
        pauseKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pauseKeyPressed.setKey(KeyboardEvent.KEY_P);
        keyboard.addEventListener(pauseKeyPressed);
    }
}
