package com.AVM.lab28;

/**
 * Created by AVM on 29.04.2016.
 */
public class Tanker extends AbstractShip {
    private float volume;
    public static final float DEFAULT_RENTAL = 250;

    public Tanker(String name, float length, float width, float displacement, float volume) {
        super(name, length, width, displacement);
        this.volume = volume;
    }

    @Override
    public float calculatePayment() {
        return volume * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rental) {
        if (rental < 1){
            return volume * DEFAULT_RENTAL;
        }
        return calculatePayment();
    }



     /*BODY*/

}
