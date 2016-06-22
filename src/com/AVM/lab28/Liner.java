package com.AVM.lab28;

/**
 * Created by AVM on 29.04.2016.
 */
public class Liner extends AbstractShip {

    private int passengers;
    public static final float DEFAULT_RENTAL = 1000;

    public Liner(String name, float length, float width, float displacement, int passengers) {
        super(name, length, width, displacement);
        this.passengers = passengers;
    }

    @Override
    public float calculatePayment() {
        return passengers * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rental) {

        if (rental < 1){
            return passengers * DEFAULT_RENTAL;
        }
        return calculatePayment();
    }
}


