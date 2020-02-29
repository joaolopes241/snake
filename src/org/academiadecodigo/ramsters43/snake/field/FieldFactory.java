package org.academiadecodigo.ramsters43.snake.field;

import org.academiadecodigo.ramsters43.snake.gfx.simplegfx.SimpleGfxField;

public class FieldFactory {

    public static Field createField(FieldType fieldType, int cols, int rows) {

        switch (fieldType) {

            case SIMPLE_GFX:

                return new SimpleGfxField(cols, rows);

            default:

                return new SimpleGfxField(cols, rows);


        }
    }
}
