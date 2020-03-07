package org.academiadecodigo.ramsters43.snake.snake;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;

import java.util.LinkedList;

public class Snake {

    private SnakeHead snakeHead;
    private LinkedList<SnakePart> snakeParts;

    private static final int colDif = 1;

    public Snake(Field field) {

        snakeHead = new SnakeHead(field.createFieldPosition(field.getCols()/2,
                field.getRows()/2));
        System.out.println("head: " + snakeHead.getFieldPosition().getCol() + ", " + snakeHead.getFieldPosition().getRow());

        snakeParts = new LinkedList<>();
        snakeParts.offer(new SnakePart(field.createFieldPosition(snakeHead.getFieldPosition().getCol() - colDif,
                snakeHead.getFieldPosition().getRow())));
        System.out.println("part1: " + snakeParts.getFirst().getFieldPosition().getCol() + ", " + snakeParts.getFirst().getFieldPosition().getRow());

        snakeParts.offer(new SnakePart(field.createFieldPosition(snakeParts.getFirst().getFieldPosition().getCol() - colDif,
                snakeParts.getFirst().getFieldPosition().getRow())));
        System.out.println("part2: " + snakeParts.getLast().getFieldPosition().getCol() + ", " + snakeParts.getLast().getFieldPosition().getRow());
    }

    public SnakeHead getSnakeHead() {

        return snakeHead;
    }


    public void move() {

        FieldPosition lastHeadPosition = snakeHead.getFieldPosition();
        FieldPosition lastSnakePart;

        snakeHead.getFieldPosition().moveToDirection(snakeHead.getCurrentFieldDirection());

        //System.out.println("position: " + snakeHead.getFieldPosition().getCol() + ", " + snakeHead.getFieldPosition().getRow());

        if (snakeHead.getFieldPosition().isGoingOutOfEdge(snakeHead.getCurrentFieldDirection())) {

            //System.out.println("here");

            snakeHead.getFieldPosition().goThroughWalls();

            //System.out.println("position: " + snakeHead.getFieldPosition().getCol() + ", " + snakeHead.getFieldPosition().getRow());
        }

        lastSnakePart = snakeParts.getFirst().getFieldPosition();
        snakeParts.getFirst().getFieldPosition().moveToPosition(lastHeadPosition);

        for (SnakePart snakePart : snakeParts) {

            if (snakePart == snakeParts.getFirst()) {
                System.out.println("blabla");
                continue;
            }

            System.out.println("here");

            snakePart.getFieldPosition().moveToPosition(lastSnakePart);
            lastSnakePart = snakePart.getFieldPosition();
        }
    }

    public void eat() {

    }

    public void die() {

    }
}
