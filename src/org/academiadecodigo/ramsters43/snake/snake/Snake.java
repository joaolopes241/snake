package org.academiadecodigo.ramsters43.snake.snake;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.item.Item;

import java.util.LinkedList;

public class Snake {

    private SnakeHead snakeHead;
    private LinkedList<SnakePart> snakeParts;
    private boolean dead = false;

    private static final int POS_DIF = 1;

    public Snake(Field field) {

        snakeHead = new SnakeHead(field.createFieldPosition(field.getCols()/2,
                field.getRows()/2, FieldColor.BLACK));

        snakeParts = new LinkedList<>();

        snakeParts.offer(new SnakePart(field.createFieldPosition(snakeHead.getFieldPosition().getCol() - POS_DIF,
                snakeHead.getFieldPosition().getRow(), FieldColor.DARK_GREEN)));

        snakeParts.offer(new SnakePart(field.createFieldPosition(snakeParts.getFirst().getFieldPosition().getCol() - POS_DIF,
                snakeParts.getFirst().getFieldPosition().getRow(), FieldColor.DARK_GREEN)));
    }

    public SnakeHead getSnakeHead() {
        return snakeHead;
    }

    public LinkedList<SnakePart> getSnakeParts() {
        return snakeParts;
    }

    public SnakePart getFirstSnakePart() {
        return snakeParts.getFirst();
    }

    public boolean isDead() {
        return dead;
    }

    public void move(Field field, Item item) {

        int lastHeadCol = snakeHead.getFieldPosition().getCol();
        int lastHeadRow = snakeHead.getFieldPosition().getRow();

        moveSnakeHead();

        if (snakeHead.getFieldPosition().equals(item.getFieldPosition())) {

            eat(field, item);
        }

        moveSnakeParts(lastHeadCol, lastHeadRow);

        checkDead();
    }

    public void eat(Field field, Item item) {

        item.getFieldPosition().hideItem();

        item.getFieldPosition().moveToPosition(this);

        snakeParts.offer(new SnakePart(field.createFieldPosition(snakeParts.getLast().getFieldPosition().getCol(),
                snakeParts.getLast().getFieldPosition().getRow(), FieldColor.DARK_GREEN)));
    }

    public void checkDead() {

        for (SnakePart snakePart : snakeParts) {

            if (snakeHead.getFieldPosition().equals(snakePart.getFieldPosition())) {
                snakePart.getFieldPosition().setSnakeColor(FieldColor.BLACK);
                dead = true;
            }
        }
    }

    public void blinkOn() {

        snakeHead.getFieldPosition().showSnake();

        for (SnakePart snakePart : snakeParts) {

            snakePart.getFieldPosition().showSnake();
        }
    }

    public void blinkOff() {

        snakeHead.getFieldPosition().hideSnake();

        for (SnakePart snakePart : snakeParts) {

            snakePart.getFieldPosition().hideSnake();
        }
    }

    private void moveSnakeHead() {

        snakeHead.getFieldPosition().moveToDirection(snakeHead.getCurrentFieldDirection());

        if (snakeHead.getFieldPosition().isGoingOutOfEdge(snakeHead.getCurrentFieldDirection())) {

            snakeHead.getFieldPosition().goThroughWalls();
        }
    }

    private void moveSnakeParts(int lastHeadCol, int lastHeadRow) {

        int lastSnakePartCol = snakeParts.getFirst().getFieldPositionCol();
        int lastSnakePartRow = snakeParts.getFirst().getFieldPositionRow();

        snakeParts.getFirst().getFieldPosition().moveToPosition(lastHeadCol, lastHeadRow);

        int savedCol;
        int savedRow;

        for (SnakePart snakePart : snakeParts) {

            if (snakePart == snakeParts.getFirst()) {
                continue;
            }

            savedCol = snakePart.getFieldPositionCol();
            savedRow = snakePart.getFieldPositionRow();

            snakePart.getFieldPosition().moveToPosition(lastSnakePartCol, lastSnakePartRow);

            lastSnakePartCol = savedCol;
            lastSnakePartRow = savedRow;
        }
    }
}
