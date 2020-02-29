package org.academiadecodigo.ramsters43.snake.field;

public enum FieldDirection {

    RIGHT,
    LEFT,
    UP,
    DOWN;


    public boolean isOpposite(FieldDirection direction) {

        return direction.equals(oppositeDirection());
    }

    public FieldDirection oppositeDirection() {

        FieldDirection opposite;

        switch (this) {

            case RIGHT:

                opposite = LEFT;
                break;

            case LEFT:

                opposite = RIGHT;
                break;

            case UP:

                opposite = DOWN;
                break;

            case DOWN:

                opposite = UP;
                break;

            default:

                opposite = LEFT;
        }

        return opposite;
    }
}
