package org.academiadecodigo.ramsters43.snake;

import org.academiadecodigo.ramsters43.snake.field.FieldType;
import org.academiadecodigo.ramsters43.snake.gamecontrols.GameControlsType;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game snakeGame = new Game(FieldType.SIMPLE_GFX, 30, 20, 100);

        snakeGame.init(GameControlsType.SIMPLE_GFX);

        snakeGame.start();
    }
}
