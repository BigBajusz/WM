package org.kodvabt.warehouse.manager.delivery;

import org.kodvabt.warehouse.manager.Order;

import java.util.*;

public class OrderHandler {
    public static final OrderHandler SINGLETON_INSTANCE = new OrderHandler(); //early-init simple singleton

    private final List<Warehouse> availableWarehouses;

    private OrderHandler() {
        availableWarehouses = new ArrayList<>();
    }

    public void addWarehouses(Warehouse... warehouses) {
        availableWarehouses.addAll(Arrays.asList(warehouses));
    }

    public void removeWarehouses(Warehouse... warehouses) {
        availableWarehouses.removeAll(Arrays.asList(warehouses));
    }

    public void handleOrder(Order order) {
        List<Transporter> transporters = new ArrayList<>();
        order.getRequestedGoods().forEach(goods ->
                availableWarehouses.stream()
                        .filter(warehouse -> warehouse.hasEnoughItem(goods))
                        .min(Comparator.comparing(Warehouse::getDistance))  //sorted(...), then findFirst()
                        .ifPresent(warehouse -> transporters.add(new Transporter(warehouse, Collections.singletonList(goods)))));

        transporters.forEach(transporter -> transporter.attach(order));
    }

}
