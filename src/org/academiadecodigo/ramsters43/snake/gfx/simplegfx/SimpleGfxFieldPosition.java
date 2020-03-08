package org.academiadecodigo.ramsters43.snake.gfx.simplegfx;

import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.field.FieldDirection;
import org.academiadecodigo.ramsters43.snake.field.fieldposition.AbstractFieldPosition;
import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxFieldPosition extends AbstractFieldPosition {

    private Rectangle rectangle;
    private SimpleGfxField simpleGfxField;


    public SimpleGfxFieldPosition(int col, int row, SimpleGfxField field) {

        super(col,row, field);

        simpleGfxField = field;

        rectangle = new Rectangle(simpleGfxField.colToX(col), simpleGfxField.rowToY(row), SimpleGfxField.CELL_SIZE, SimpleGfxField.CELL_SIZE);

        setColor(FieldColor.DARK_GREEN);
    }


    @Override
    public void show() {

        rectangle.fill();
    }

    @Override
    public void hide() {

        rectangle.delete();
    }

    @Override
    public void setColor(FieldColor color) {

        super.setColor(color);

        rectangle.setColor(SimpleGfxColors.defineColor(color));

        show();
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

        System.out.println("pos col: " + col + ", pos row: " + row);
        int initialCol = getCol();
        int initialRow = getRow();

        super.moveToPosition(col, row);
        System.out.println("dx: " + dx(initialCol) + " dy: " + dy(initialRow));
        rectangle.translate(dx(initialCol), dy(initialRow));
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
