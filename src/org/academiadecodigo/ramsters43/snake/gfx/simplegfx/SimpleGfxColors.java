package org.academiadecodigo.ramsters43.snake.gfx.simplegfx;

import org.academiadecodigo.ramsters43.snake.field.FieldColor;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class SimpleGfxColors {

    public static Color defineColor(FieldColor color) {

        Color simpleGfxColor = null;

        switch (color) {

            case BROWN:

                simpleGfxColor = new Color(139, 69, 19);
                break;

            case MUSTARD:

                simpleGfxColor = new Color(255, 219, 88);
                break;

            case DARK_GREEN:

                simpleGfxColor = new Color(0, 100, 0);
                break;

            case NO_COLOR:

                simpleGfxColor = Color.WHITE;
                break;

            default:

                System.out.println("You have to choose a valid color...");
        }

        return simpleGfxColor;
    }
}
