package org.academiadecodigo.ramsters43.snake.item;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;

public class Item {

    private FieldPosition fieldPosition;

    public Item(Field field) {

        fieldPosition = field.createFieldPosition(FieldColor.GRAY);
    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }
}
