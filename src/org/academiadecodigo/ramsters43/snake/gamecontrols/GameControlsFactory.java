package org.academiadecodigo.ramsters43.snake.gamecontrols;

import org.academiadecodigo.ramsters43.snake.Game;
import org.academiadecodigo.ramsters43.snake.gfx.simplegfx.SimpleGfxGameControls;
import org.academiadecodigo.ramsters43.snake.snake.Snake;

public class GameControlsFactory {

    public static GameControls createGameControls(GameControlsType gameControlsType, Snake snake, Game game) {

        switch (gameControlsType) {

            case SIMPLE_GFX:

                return new SimpleGfxGameControls(snake, game);

            default:

                return new SimpleGfxGameControls(snake, game);

        }
    }
}
