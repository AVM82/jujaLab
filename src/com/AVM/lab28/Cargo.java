package com.AVM.lab28;

/**
 * Created by AVM on 29.04.2016.
 */
public class Cargo extends AbstractShip {
    private float tonnage;
    public static final float DEFAULT_RENTAL=550;

    public Cargo(String name, float length, float width, float displacement, float tonnage) {
        super(name, length, width, displacement);
        this.tonnage = tonnage;
    }

    @Override
    public float calculatePayment() {
        return tonnage * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rental){
        if (rental < 1){
            return tonnage * DEFAULT_RENTAL;
        }
        return calculatePayment();
    }

}