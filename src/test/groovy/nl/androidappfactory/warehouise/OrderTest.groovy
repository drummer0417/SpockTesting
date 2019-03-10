package nl.androidappfactory.warehouise

import spock.lang.Specification

class OrderTest extends Specification {

    def "Fill an order if there's enough eventory"() {

        given: "an order and a warehouse"
        def order = new Order("Laptop", 10)
        Warehouse warehouse = Mock();

        when: "an order is filled"
        warehouse.hasInventory("Laptop", 10) >> true
        order.fill(warehouse)

        then: "order is filled and inventory is removed from warehous"
        order.filled()
        1 * warehouse.remove("Laptop", 10)
//      1 * warehouse.remove(_, _).......................... called once for any article/amount
//      (1..4) * warehouse.remove("Laptop", 10)........ called 1, 2, 3 or 4 times
    }

    def "Don't fill an order if there's no eventory"() {

        given: "an order and a warehouse"
        def order = new Order("Laptop", 10)
        Warehouse warehouse = Mock();

        when: "an order is filled"
        warehouse.hasInventory("Laptop", 10) >> false
        order.fill(warehouse)

        then: "order should not be filled and inventory should not be removed from warehous"
        !order.filled()
        0 * warehouse.remove(_, _)
    }

    def "Event message is posted when article is removed from warehouse"(){

        given: "a warehouse with event bus"
        EventBus eventBus = Mock()
        Warehouse warehouse = new Warehouse(eventBus)

        when: "inventory is removed from warehous"
        warehouse.remove("Laptop", 50)

        then: "an async message is posted"
        1 * eventBus.post(EventBus.ASYNC,{
            ((Order)(it)).article == "Laptop"
            ((Order)(it)).amount == 50
        })
    }
}
