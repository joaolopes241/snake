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

    public FieldDirection getCurrentFieldDirection() {

        return currentFieldDirection;
    }

    public void changeCurrentFieldDirection(FieldDirection direction) {

        if (currentFieldDirection.isOpposite(direction) || currentFieldDirection.equals(direction)) {

            return;
        }

        currentFieldDirection = direction;
    }
}
