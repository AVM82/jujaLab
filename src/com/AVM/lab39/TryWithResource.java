package com.AVM.lab39;

/**
 * Created by AVM on 21.07.2016.
 */

public class TryWithResource {
    public static void twoResource(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body) throws Throwable {

        AutoCloseable resourceA;
        AutoCloseable resourceB;
        resourceA = getResource(factoryA);
        resourceB = getResource(factoryB,resourceA);
        try{

            body.runBody();

        }catch (Throwable bodyEx){
            closeResources(resourceA,resourceB,bodyEx);
            throw bodyEx;
        }
        closeResources(resourceA,resourceB);
    }

    private static void closeResources(AutoCloseable first, AutoCloseable second) throws Exception {
        try {
            second.close();
        }catch (Throwable closeBEx){
            try {
                first.close();
            }catch (Throwable closeAEx){
                closeBEx.addSuppressed(closeAEx);
            }
            throw closeBEx;
        }
        first.close();
    }
    private static void closeResources(AutoCloseable first, AutoCloseable second, Throwable bodyEx){
        try {
            second.close();
        }catch (Throwable closeBEx){
            bodyEx.addSuppressed(closeBEx);
        }
        try {
            first.close();
        }catch (Throwable closeAEx){
            bodyEx.addSuppressed(closeAEx);
        }
    }
    private static AutoCloseable getResource(AutoCloseableFactory factory,AutoCloseable resource) throws Throwable {
        try{
            return factory.create();
        }catch (Throwable create){
            try {
                resource.close();
            }catch (Throwable close){
                create.addSuppressed(close);
            }
            throw create;
        }
    }
    private static AutoCloseable getResource(AutoCloseableFactory factory) throws Throwable {
            return factory.create();
    }
}

interface AutoCloseableFactory {
    public AutoCloseable create() throws Throwable;
}
interface TryBody {
    public void runBody() throws Throwable;
}
