package nl.androidappfactory.warehouise;

public class Warehouse {


    EventBus eventBus;

    public Warehouse() {

    }

    public Warehouse(EventBus eventBus) {

        this.eventBus = eventBus;
    }

    public boolean hasInventory(String article, int amount) {

        System.out.println("no inventory for " + article + " , " + amount);
        return false;
    }

    public void remove(String article, int amount) {

        System.out.println("article " + article + ", " + amount + " removed");
        if (eventBus != null){
            eventBus.post(EventBus.ASYNC, new Order(article, amount));
        }
    }
}
