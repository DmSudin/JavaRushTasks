package com.javarush.task.task25.task2515;

public class Ufo extends BaseObject {
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };
    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawMatrix(x-radius+1, y-radius+1, matrix, 'U');
    }

    @Override
    public void move() {
        super.move();
        if (Math.random() >= 0.9) fire();
        double dx = Math.random()*2-1;
        double dy = Math.random()*2-1;
        x+=dx;
        y+=dy;
        checkBorders(0, Space.game.getWidth(), y, Space.game.getHeight()/2);


    }

    public void fire() {
        Space.game.getBombs().add(new Bomb(x, y + radius));
    }
}
