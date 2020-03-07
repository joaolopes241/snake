package org.academiadecodigo.ramsters43.snake.gfx.simplegfx;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxField implements Field {

    public static final int BORDER = 20;
    public static final int CELL_SIZE = 20;

    private int fieldCols;
    private int fieldRows;

    private int fieldWidth;
    private int fieldHeight;

    private Rectangle fieldMargin;
    private Rectangle fieldBackground;

    public SimpleGfxField(int cols, int rows) {

        fieldCols = cols;
        fieldRows = rows;

        fieldWidth = cols * CELL_SIZE;
        fieldHeight = rows * CELL_SIZE;
    }

    @Override
    public void init() {

        fieldMargin = new Rectangle(0, 0, fieldWidth + BORDER, fieldHeight + BORDER);
        fieldMargin.fill();

        fieldMargin.setColor(SimpleGfxColors.defineColor(FieldColor.BROWN));


        fieldBackground = new Rectangle(BORDER, BORDER, fieldWidth - BORDER, fieldHeight - BORDER);
        fieldBackground.fill();

        fieldBackground.setColor(SimpleGfxColors.defineColor(FieldColor.MUSTARD));
    }

    @Override
    public int getBorder() {

        return BORDER/CELL_SIZE;
    }

    @Override
    public int getCols() {

        return fieldCols;
    }

    @Override
    public int getRows() {

        return fieldRows;
    }

    public int getWidth() {

        return fieldWidth;
    }

    public int getHeight() {

        return fieldHeight;
    }

    public int getX() {

        return fieldBackground.getX();
    }

    public int getY() {

        return fieldBackground.getY();
    }


    @Override
    public FieldPosition createFieldPosition(int col, int row) {

        return new SimpleGfxFieldPosition(col,row, this);
    }


    public int colToX(int col) {

        return col * CELL_SIZE;
    }

    public int rowToY(int row) {

        return row * CELL_SIZE;
    }
}
