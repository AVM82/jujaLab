package com.AVM.lab28;

/**
 * Created by AVM on 29.04.2016.
 */
interface SeaPortQueue {
    public final static int LENGTH_QUEUE_SHIP = 3;
    public int addShipToEndQueue(AbstractShip ship);
    public int removeShipFromBeginQueue();
    public String printQueueShip();
}