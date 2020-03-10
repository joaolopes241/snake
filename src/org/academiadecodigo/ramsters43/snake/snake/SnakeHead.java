package org.academiadecodigo.ramsters43.snake.snake;

import org.academiadecodigo.ramsters43.snake.field.FieldDirection;
import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;

public class SnakeHead {

    private FieldPosition fieldPosition;
    private FieldDirection currentFieldDirection;

    public SnakeHead(FieldPosition fieldPosition) {

        this.fieldPosition = fieldPosition;
        currentFieldDirection = FieldDirection.RIGHT;
    }

    public FieldPosition getFieldPosition() {

        return fieldPosition;
    }

    public int getFieldPositionCol() {

        return fieldPosition.getCol();
    }

    public int getFieldPositionRow() {

        return fieldPosition.getRow();
    }

    public FieldDirection getCurrentFieldDirection() {

        return currentFieldDirection;
    }

    public void changeCurrentFieldDirection(FieldDirection direction, Snake snake) {

        if (direction == FieldDirection.RIGHT && this.fieldPosition.getCol() + 1 == snake.getFirstSnakePart().getFieldPositionCol()) {
            return;
        }

        if (direction == FieldDirection.LEFT && this.fieldPosition.getCol() - 1 == snake.getFirstSnakePart().getFieldPositionCol()) {
            return;
        }

        if (direction == FieldDirection.UP && this.fieldPosition.getRow() - 1 == snake.getFirstSnakePart().getFieldPositionRow()) {
            return;
        }
        if (direction == FieldDirection.DOWN && this.fieldPosition.getRow() + 1 == snake.getFirstSnakePart().getFieldPositionRow()) {
            return;
        }

        currentFieldDirection = direction;
    }
}
