package org.academiadecodigo.ramsters43.snake;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.FieldFactory;
import org.academiadecodigo.ramsters43.snake.field.FieldType;
import org.academiadecodigo.ramsters43.snake.gamecontrols.GameControls;
import org.academiadecodigo.ramsters43.snake.gamecontrols.GameControlsFactory;
import org.academiadecodigo.ramsters43.snake.gamecontrols.GameControlsType;
import org.academiadecodigo.ramsters43.snake.snake.Snake;
import org.academiadecodigo.ramsters43.snake.snake.SnakeFactory;

public class Game {

    private Field field;

    private Snake snake;

    private GameControls gameControls;

    private int delay;

    public Game(FieldType fieldType, int cols, int rows, int delay) {

        field = FieldFactory.createField(fieldType, cols, rows);

        this.delay = delay;
    }


    public void init(GameControlsType gameControlsType) {

        field.init();

        snake = SnakeFactory.getNewSnake(field);

        gameControls = GameControlsFactory.createGameControls(gameControlsType, snake);

        gameControls.init();
    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(delay);

            snake.move();
        }
    }
}
