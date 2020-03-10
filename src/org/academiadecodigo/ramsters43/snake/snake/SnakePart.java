package org.academiadecodigo.ramsters43.snake.snake;

import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;

public class SnakePart {

    private FieldPosition fieldPosition;

    public SnakePart(FieldPosition fieldPosition) {

        this.fieldPosition = fieldPosition;
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
}
