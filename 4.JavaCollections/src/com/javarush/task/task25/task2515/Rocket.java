package com.javarush.task.task25.task2515;

public class Rocket extends BaseObject {
    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.setPoint(x, y, 'R');
    }

    @Override
    public void move() {
        super.move();
        y--;
    }
}
