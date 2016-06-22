package com.AVM.lab28;

public class Main {

    public static void main(String[] args) {
        Liner liner = new Liner("liner",358.5f,33.9f,99.9f,9);
        Cargo cargo = new Cargo("cargo",358.5f,33.9f,99.9f,9);
        Tanker tanker = new Tanker("tanker",358.5f,33.9f,99.9f,9);

        OdessaSeaPort odessaSeaPort = new OdessaSeaPort();

//        odessaSeaPort.addShipToEndQueue(liner);
//        odessaSeaPort.addShipToEndQueue(cargo);
//        odessaSeaPort.addShipToEndQueue(tanker);
//        odessaSeaPort.addShipToEndQueue(liner2);
        System.out.println(odessaSeaPort.addShipToEndQueue(tanker));
        System.out.println(odessaSeaPort.addShipToEndQueue(liner));
        System.out.println(odessaSeaPort.addShipToEndQueue(cargo));
        System.out.println(odessaSeaPort.sortSumPaymentAsc(new AbstractShip[] {} ));
        System.out.println(odessaSeaPort.sortSumPaymentAsc(null));
        System.out.println(odessaSeaPort.sortSumPaymentAsc(new AbstractShip[]{liner,tanker,cargo}));
    }
}
