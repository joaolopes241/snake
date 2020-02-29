package org.academiadecodigo.ramsters43.snake.field.fieldposition;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.field.FieldDirection;


/**
 * Blueprint of Position
 */
public abstract class AbstractFieldPosition implements FieldPosition {

    private int col;
    private int row;

    private Field field;
    private FieldColor fieldColor;


    public AbstractFieldPosition(int col, int row, Field field) {

        this.col = col;
        this.row = row;

        this.field = field;
        this.fieldColor = FieldColor.NO_COLOR;
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

        show();
    }

    @Override
    public FieldColor getColor() {

        return fieldColor;
    }

    @Override
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

                moveRight();

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
