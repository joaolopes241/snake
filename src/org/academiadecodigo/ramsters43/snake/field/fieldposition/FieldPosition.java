package org.academiadecodigo.ramsters43.snake.field.fieldposition;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.field.FieldDirection;
import org.academiadecodigo.ramsters43.snake.snake.Snake;

public interface FieldPosition {

    public int getCol();

    public int getRow();

    public void setPos(int col, int row);

    public void setPos(Snake snake);


    public FieldColor getColor();

    public void showSnake();

    public void hideSnake();

    public void setSnakeColor(FieldColor color);

    public void showItem();

    public void hideItem();

    public void setItemColor(FieldColor color);

    public void moveToDirection(FieldDirection direction);

    public void moveToPosition(int col, int row);

    public void moveToPosition(Snake snake);

    public boolean equals(FieldPosition position);

    public boolean isGoingOutOfEdge(FieldDirection direction);

    public void goThroughWalls();

}