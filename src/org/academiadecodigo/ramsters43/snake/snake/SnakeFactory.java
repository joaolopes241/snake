package org.academiadecodigo.ramsters43.snake.snake;

import org.academiadecodigo.ramsters43.snake.field.Field;

public class SnakeFactory {

    public static Snake getNewSnake(Field field) {

        Snake snake;

        snake = new Snake(field.createFieldPosition(field.getCols() - 1, field.getRows() - 1));

        return snake;
    }
}
