package org.academiadecodigo.ramsters43.snake.gfx.simplegfx;

import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.field.FieldDirection;
import org.academiadecodigo.ramsters43.snake.field.fieldposition.AbstractFieldPosition;
import org.academiadecodigo.ramsters43.snake.snake.Snake;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxFieldPosition extends AbstractFieldPosition {

    private Rectangle rectangle;
    private Ellipse ellipse;
    private SimpleGfxField simpleGfxField;


    public SimpleGfxFieldPosition(int col, int row, SimpleGfxField field, FieldColor color) {

        super(col,row, field, color);

        simpleGfxField = field;

        rectangle = new Rectangle(simpleGfxField.colToX(getCol()), simpleGfxField.rowToY(getRow()), SimpleGfxField.CELL_SIZE,
                SimpleGfxField.CELL_SIZE);

        setSnakeColor(color);
    }

    public SimpleGfxFieldPosition(SimpleGfxField field, FieldColor color) {

        super(field, color);

        simpleGfxField = field;

        ellipse = new Ellipse(simpleGfxField.colToX(getCol()) + 1, simpleGfxField.rowToY(getRow()) + 1,
                SimpleGfxField.CELL_SIZE - 2, SimpleGfxField.CELL_SIZE - 2);

        setItemColor(color);
    }


    @Override
    public void showSnake() {

        rectangle.fill();
    }

    @Override
    public void hideSnake() {

        rectangle.delete();
    }

    @Override
    public void setSnakeColor(FieldColor color) {

        super.setColor(color);

        rectangle.setColor(SimpleGfxColors.defineColor(color));

        showSnake();
    }

    @Override
    public void showItem() {

        ellipse.fill();
    }

    @Override
    public void hideItem() {

        ellipse.delete();
    }

    @Override
    public void setItemColor(FieldColor color) {

        super.setColor(color);

        ellipse.setColor(SimpleGfxColors.defineColor(color));

        showItem();
    }


    @Override
    public void moveToDirection(FieldDirection direction) {

        int initialCol = getCol();
        int initialRow = getRow();

        super.moveToDirection(direction);

        rectangle.translate(dx(initialCol), dy(initialRow));
    }

    @Override
    public void moveToPosition(int col, int row) {

        int initialCol = getCol();
        int initialRow = getRow();

        super.moveToPosition(col, row);

        rectangle.translate(dx(initialCol), dy(initialRow));
    }

    @Override
    public void moveToPosition(Snake snake) {

        int initialCol = getCol();
        int initialRow = getRow();

        super.moveToPosition(snake);

        ellipse.translate(dx(initialCol), dy(initialRow));
    }

    @Override
    public void goThroughWalls() {

        int initialCol = getCol();
        int initialRow = getRow();

        super.goThroughWalls();

        rectangle.translate(dx(initialCol), dy(initialRow));

    }

    private int dx(int initialCol) {

        return simpleGfxField.colToX(getCol()) - simpleGfxField.colToX(initialCol);
    }

    private int dy(int initialRow) {

        return simpleGfxField.rowToY(getRow()) - simpleGfxField.rowToY(initialRow);
    }
}
