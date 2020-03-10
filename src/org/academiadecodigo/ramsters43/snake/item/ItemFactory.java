package org.academiadecodigo.ramsters43.snake.item;

import org.academiadecodigo.ramsters43.snake.field.Field;

public class ItemFactory {

    public static Item getNewItem(Field field) {

        return new Item(field);
    }
}
