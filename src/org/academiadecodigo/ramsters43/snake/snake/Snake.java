package org.academiadecodigo.ramsters43.snake.snake;

import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;

public class Snake {

    private SnakeHead snakeHead;

    //private SnakePart[] snakeParts;


    public Snake(FieldPosition fieldPosition) {

        snakeHead = new SnakeHead(fieldPosition);

        //snakeParts = new SnakePart[1000];
    }

    public SnakeHead getSnakeHead() {

        return snakeHead;
    }


    public void move() {

        snakeHead.getFieldPosition().moveToDirection(snakeHead.getCurrentFieldDirection());

        System.out.println("position: " + snakeHead.getFieldPosition().getCol() + ", " + snakeHead.getFieldPosition().getRow());

        if (snakeHead.getFieldPosition().isGoingOutOfEdge(snakeHead.getCurrentFieldDirection())) {

            System.out.println("here");

            snakeHead.getFieldPosition().goThroughWalls();

            System.out.println("position: " + snakeHead.getFieldPosition().getCol() + ", " + snakeHead.getFieldPosition().getRow());
        }

    }

    public void eat() {

    }

    public void die() {

    }
}
