package org.academiadecodigo.ramsters43.snake.field.fieldposition;

import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.field.FieldDirection;

public interface FieldPosition {

    public int getCol();

    public int getRow();

    public void setPos(int col, int row);


    public FieldColor getColor();

    public void setColor(FieldColor color);


    public void show();

    public void hide();


    public void moveToDirection(FieldDirection direction);

    public void moveToPosition(int col, int row);

    public boolean equals(FieldPosition position);

    public boolean isGoingOutOfEdge(FieldDirection direction);

    public void goThroughWalls();

}