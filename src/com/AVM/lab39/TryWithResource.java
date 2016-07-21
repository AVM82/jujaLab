package com.AVM.lab39;

/**
 * Created by AVM on 21.07.2016.
 */

public class TryWithResource {
//    private AutoCloseable createResourceA() throws Throwable{
//
//    }
    public static void twoResource(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body) throws Throwable {
      /*BODY*/


        AutoCloseable resourceA;
        AutoCloseable resourceB ;
        try{
            resourceA = factoryA.create();

        }catch (Throwable createA){
           throw createA;

        }
        try{
            resourceB = factoryB.create();

        }catch (Throwable createB){
            try {

                resourceA.close();
            }catch (Throwable closeAEx){
                createB.addSuppressed(closeAEx);

            }

            throw createB;

        }

        try{

            body.runBody();

        }catch (Throwable bodyEx){

            try {

                resourceB.close();
            }catch (Throwable closeBEx){
                bodyEx.addSuppressed(closeBEx);

            }
            try {

                resourceA.close();
            }catch (Throwable closeAEx){
                bodyEx.addSuppressed(closeAEx);

            }
            throw bodyEx;


        }
        try {

            resourceB.close();
        }catch (Throwable closeBEx){
            try {

                resourceA.close();
            }catch (Throwable closeAEx){
                closeBEx.addSuppressed(closeAEx);

            }
            throw closeBEx;

        }
        try {
            resourceA.close();
        }catch (Throwable closeA){
            throw closeA;

        }

    }
}







interface AutoCloseableFactory {
    public AutoCloseable create() throws Throwable;
}



interface TryBody {
    public void runBody() throws Throwable;
}
