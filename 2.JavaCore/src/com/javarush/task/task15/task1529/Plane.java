package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    public int peopleAmount;
    @Override
    public void fly() {

    }

    public Plane(int peopleAmount){
        this.peopleAmount = peopleAmount;
    }
}
