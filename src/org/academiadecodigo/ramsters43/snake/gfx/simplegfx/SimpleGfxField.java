package org.academiadecodigo.ramsters43.snake.gfx.simplegfx;

import org.academiadecodigo.ramsters43.snake.field.Field;
import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.ramsters43.snake.field.fieldposition.FieldPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxField implements Field {

    public static final int BORDER = 20;

    private int fieldCols;
    private int fieldRows;

    private int cellSize;

    private int fieldWidth;
    private int fieldHeight;

    private Rectangle fieldMargin;
    private Rectangle fieldBackground;

    public SimpleGfxField(int cols, int rows) {

        cellSize = 20;

        fieldCols = cols;
        fieldRows = rows;

        fieldWidth = cols * cellSize;
        fieldHeight = rows * cellSize;
    }

    @Override
    public void init() {

        fieldMargin = new Rectangle(0, 0, fieldWidth + BORDER, fieldHeight + BORDER);
        fieldMargin.fill();

        fieldMargin.setColor(SimpleGfxColors.getColor(FieldColor.BROWN));


        fieldBackground = new Rectangle(BORDER, BORDER, fieldWidth - BORDER, fieldHeight - BORDER);
        fieldBackground.fill();

        fieldBackground.setColor(SimpleGfxColors.getColor(FieldColor.MUSTARD));
    }

    @Override
    public int getBorder() {

        return BORDER/cellSize;
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

    public int getCellSize(){

        return cellSize;
    }


    @Override
    public FieldPosition createFieldPosition(int col, int row) {

        return new SimpleGfxFieldPosition(col/2,row/2, this);
    }


    public int colToX(int col) {

        return BORDER + col * cellSize;
    }

    public int rowToY(int row) {

        return BORDER + row * cellSize;
    }
}
