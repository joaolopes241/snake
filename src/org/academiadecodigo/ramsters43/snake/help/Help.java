package org.academiadecodigo.ramsters43.snake.help;

public class Help {

    public static int generateRandomNumber(int max, int border) {

        return Math.toIntExact(Math.round(Math.random() * (max - 2 * border) + border));
    }
}
