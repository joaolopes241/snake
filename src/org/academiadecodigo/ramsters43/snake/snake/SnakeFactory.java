package org.academiadecodigo.ramsters43.snake.snake;

import org.academiadecodigo.ramsters43.snake.field.Field;

public class SnakeFactory {

    public static Snake getNewSnake(Field field) {

        return new Snake(field);
    }
}
