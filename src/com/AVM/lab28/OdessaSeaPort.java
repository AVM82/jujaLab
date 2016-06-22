package com.AVM.lab28;


import java.util.Arrays;

/**
 * Created by AVM on 29.04.2016.
 */
class OdessaSeaPort implements SeaPortQueue {
    private static final int NO_SHIP_IN_ARRAY = -1;
    private int indexShipInPort = NO_SHIP_IN_ARRAY;
    private AbstractShip[] arrayShip = new AbstractShip[LENGTH_QUEUE_SHIP];
    /*BODY*/

    @Override
    public int addShipToEndQueue(AbstractShip ship) {
        for (int i = 0; i < arrayShip.length; i++) {
            if (arrayShip[i] == null){
                arrayShip[i] = ship;
                return i;
            }
        }

        return -1;
    }

    @Override
    public int removeShipFromBeginQueue() {
        if (arrayShip[0] != null){
            arrayShip[0] = null;
            System.arraycopy(arrayShip,1,arrayShip,0,LENGTH_QUEUE_SHIP-1);
            arrayShip[LENGTH_QUEUE_SHIP-1] = null;
            return 1;
        }

        return -1;
    }

    @Override
    public String printQueueShip() {
        if (arrayShip[0] != null){
            String s = "";

            for (int i = 0; i < arrayShip.length; i++){
                if (arrayShip[i] != null){
                    s += "{"+arrayShip[i].toPrint()+"};";
                }
            }
            return s;
        }

        return "QueueEmpty";
    }



    public static String sortSumPaymentAsc(AbstractShip[] arrayShips) {
        String returnStr = "";
        if ((arrayShips == null )||(arrayShips.length == 0))
        {
            return returnStr;
        }
        class SumPayment implements Comparable{
                private String shipName;
                private float payment;

                public SumPayment(String shipName, float payment){
                    this.shipName = shipName;
                    this.payment = payment;
                }

                @Override
                public int compareTo(Object o) {
                    SumPayment sP = (SumPayment)o;
                    return (int) (payment - sP.payment);
                }
        }
        SumPayment[] sumPayment = new SumPayment[arrayShips.length];
            for (int i = 0; i < sumPayment.length; i++) {
                sumPayment[i] = new SumPayment(arrayShips[i].getName(),arrayShips[i].calculatePayment());
            }
            Arrays.sort(sumPayment);

        for (int i = 0; i < sumPayment.length; i++) {

                returnStr += sumPayment[i].shipName+"="+sumPayment[i].payment;
            }
        return returnStr;


    }
    /*END BODY*/
}