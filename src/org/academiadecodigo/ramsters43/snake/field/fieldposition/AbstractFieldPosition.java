package org.academiadecodigo.ramsters43.snake.field.fieldposition;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.field.FieldDirection;
import org.academiadecodigo.ramsters43.snake.help.Help;
import org.academiadecodigo.ramsters43.snake.snake.Snake;
import org.academiadecodigo.ramsters43.snake.snake.SnakePart;


/**
 * Blueprint of Position
 */
public abstract class AbstractFieldPosition implements FieldPosition {

    private int col;
    private int row;

    private Field field;
    private FieldColor fieldColor;


    public AbstractFieldPosition(int col, int row, Field field, FieldColor color) {

        this.col = col;
        this.row = row;

        this.field = field;
        this.fieldColor = color;
    }

    public AbstractFieldPosition(Field field, FieldColor color) {

        this.col = Math.toIntExact(Math.round(Math.random() * (field.getCols() - field.getBorder()) + field.getBorder()));
        this.row = Math.toIntExact(Math.round(Math.random() * (field.getRows() - field.getBorder()) + field.getBorder()));

        this.field = field;
        this.fieldColor = color;
    }


    public Field getField() {

        return field;
    }

    @Override
    public int getCol() {

         return col;
    }

    @Override
    public int getRow() {

        return row;
    }

    @Override
    public void setPos(int col, int row) {

        this.col = col;
        this.row = row;

        showSnake();
    }

    @Override
    public void setPos(Snake snake) {

        this.col = Help.generateRandomNumber(field.getCols(), field.getBorder());
        this.row = Help.generateRandomNumber(field.getRows(), field.getBorder());

        if (col == snake.getSnakeHead().getFieldPositionCol() && row == snake.getSnakeHead().getFieldPositionRow()) {

            setPos(snake);
            return;
        }

        for (SnakePart snakePart : snake.getSnakeParts()) {

            if (col == snakePart.getFieldPositionCol() && row == snakePart.getFieldPositionRow()) {

                setPos(snake);
                return;
            }
        }

        showItem();
    }

    @Override
    public FieldColor getColor() {

        return fieldColor;
    }

    public void setColor(FieldColor color) {

        fieldColor = color;
    }


    @Override
    public void moveToDirection(FieldDirection direction) {

        switch (direction) {

            case RIGHT:

                moveRight();
                break;

            case LEFT:

                moveLeft();
                break;

            case UP:

                moveUp();
                break;

            case DOWN:

                moveDown();
                break;

            default:
                System.out.println("What move is this? O.o");
        }
    }

    private void moveRight() {

        setPos(getCol() + 1, getRow());
    }

    private void moveLeft() {

        setPos(getCol() - 1, getRow());
    }

    private void moveUp() {

        setPos(getCol(), getRow() - 1);
    }

    private void moveDown() {

        setPos(getCol(), getRow() + 1);
    }


    @Override
    public void moveToPosition(int col, int row) {
        setPos(col, row);
    }

    @Override
    public void moveToPosition(Snake snake) {
        setPos(snake);
    }

    @Override
    public boolean equals(FieldPosition position) {

        return col == position.getCol() && row == position.getRow();
    }


    @Override
    public boolean isGoingOutOfEdge(FieldDirection direction) {

        if (direction == FieldDirection.LEFT && getCol() == 0) {

            return true;
        }

        if (direction == FieldDirection.RIGHT && getCol() == field.getCols()) {

            return true;
        }

        if (direction == FieldDirection.UP && getRow() == 0) {

            return true;
        }

        if (direction == FieldDirection.DOWN && getRow() == field.getRows()) {

            return true;
        }

        return false;
    }

    public void goThroughWalls() {

        if (getCol() == 0) {

            setColToMax();
            return;
        }

        if (getCol() == field.getCols()) {

            setColToMin();
            return;
        }

        if (getRow() == 0) {

            setRowToMax();
            return;
        }

        setRowToMin();
    }

    private void setColToMin() {

        col = field.getBorder();
    }

    private void setColToMax() {

        col = field.getCols() - field.getBorder();
    }

    private void setRowToMin() {

        row = field.getBorder();
    }

    private void setRowToMax() {

        row = field.getRows() - field.getBorder();
    }
}
