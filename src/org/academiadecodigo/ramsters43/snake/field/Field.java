package org.academiadecodigo.ramsters43.snake.field;

import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;

public interface Field {

    public void init();

    public int getBorder();

    public int getCols();

    public int getRows();

    public FieldPosition createFieldPosition(int col, int row);

}
