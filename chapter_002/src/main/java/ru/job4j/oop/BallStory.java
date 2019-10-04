package ru.job4j.oop;

public class BallStory {
    Ball ball = new Ball();
    Hare hare = new Hare();
    Wolf wolf = new Wolf();
    Fox fox = new Fox();

    hare.tryEat(ball);
    wolf.tryEat(ball);
    fox.tryEat(ball);
}
