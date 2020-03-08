package org.academiadecodigo.ramsters43.snake.snake;

import org.academiadecodigo.ramsters43.snake.field.Field;

import java.util.LinkedList;

public class Snake {

    private SnakeHead snakeHead;
    private LinkedList<SnakePart> snakeParts;

    private static final int colDif = 1;

    public Snake(Field field) {

        snakeHead = new SnakeHead(field.createFieldPosition(field.getCols()/2,
                field.getRows()/2));

        snakeParts = new LinkedList<>();

        snakeParts.offer(new SnakePart(field.createFieldPosition(snakeHead.getFieldPosition().getCol() - colDif,
                snakeHead.getFieldPosition().getRow())));

        snakeParts.offer(new SnakePart(field.createFieldPosition(snakeParts.getFirst().getFieldPosition().getCol() - colDif,
                snakeParts.getFirst().getFieldPosition().getRow())));
    }

    public SnakeHead getSnakeHead() {

        return snakeHead;
    }


    public void move() {

        int lastHeadCol = snakeHead.getFieldPosition().getCol();
        int lastHeadRow = snakeHead.getFieldPosition().getRow();

        moveSnakeHead();

        moveSnakeParts(lastHeadCol, lastHeadRow);
    }

    public void eat() {

    }

    public void die() {

    }

    private void moveSnakeHead() {

        snakeHead.getFieldPosition().moveToDirection(snakeHead.getCurrentFieldDirection());

        if (snakeHead.getFieldPosition().isGoingOutOfEdge(snakeHead.getCurrentFieldDirection())) {

            snakeHead.getFieldPosition().goThroughWalls();
        }
    }

    private void moveSnakeParts(int lastHeadCol, int lastHeadRow) {

        int lastSnakePartCol = snakeParts.getFirst().getFieldPosition().getCol();
        int lastSnakePartRow = snakeParts.getFirst().getFieldPosition().getRow();

        snakeParts.getFirst().getFieldPosition().moveToPosition(lastHeadCol, lastHeadRow);

        for (SnakePart snakePart : snakeParts) {

            if (snakePart == snakeParts.getFirst()) {
                continue;
            }

            snakePart.getFieldPosition().moveToPosition(lastSnakePartCol, lastSnakePartRow);

            lastSnakePartCol = snakePart.getFieldPosition().getCol();
            lastSnakePartRow = snakePart.getFieldPosition().getRow();
        }
    }
}
