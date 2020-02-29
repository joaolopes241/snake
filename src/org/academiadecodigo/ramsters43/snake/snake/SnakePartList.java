package org.academiadecodigo.ramsters43.snake.snake;

import java.util.LinkedList;

public class SnakePartList {

    private LinkedList<SnakePart> snakePartsList;

    public SnakePartList() {

        snakePartsList = new LinkedList<>();
    }

    public void addSnakePart(SnakePart snakePart) {

        snakePartsList.addLast(snakePart);
    }
}
