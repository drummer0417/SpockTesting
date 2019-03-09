package nl.androidappfactory.warehouise;

public class EventBus {

    public static final String ASYNC = "ASync:";
    public static final String SYNC = "Sync:";

    public void post(String syncOrAsync, Order order){

        System.out.println("EventBus posted...");
    }
}
