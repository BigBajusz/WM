package org.kodvabt.warehouse.manager;

import org.kodvabt.warehouse.manager.customer.strategy.CustomerStrategy;
import org.kodvabt.warehouse.manager.delivery.Observer;
import org.kodvabt.warehouse.manager.delivery.Transporter;
import org.kodvabt.warehouse.manager.delivery.Warehouse;
import org.kodvabt.warehouse.manager.goods.Goods;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order implements Observer {
    private final UUID id;
    private final UUID userId;
    private final List<Goods> requestedGoods;
    private final List<Goods> acquiredGoods;
    private final LocalDateTime orderDate;
    private final LocalDateTime expectedDeliveryDate;
    private final String addressToDeliver;
    private final CustomerStrategy customerStrategy;
    private final int cost;
    private boolean completed;

    public Order(UUID userId, List<Goods> requestedGoods, String addressToDeliver, CustomerStrategy customerStrategy, int cost) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.requestedGoods = requestedGoods;
        this.orderDate = LocalDateTime.now();
        this.expectedDeliveryDate = orderDate.minusDays(4);
        this.customerStrategy = customerStrategy;
        this.addressToDeliver = addressToDeliver;
        this.cost = cost;
        this.acquiredGoods = new ArrayList<>();
        this.completed = false;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public List<Goods> getRequestedGoods() {
        return requestedGoods;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public String getAddressToDeliver() {
        return addressToDeliver;
    }

    public CustomerStrategy getCustomerStrategy() {
        return customerStrategy;
    }

    public int getCost() {
        return cost;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void update(Transporter o) {
        acquiredGoods.addAll(o.getWarehouseGoods());
        o.detach(this);
        if (acquiredGoods.containsAll(requestedGoods)) {
            deliverOrder();
        }
    }

    private void deliverOrder() {
        Transporter transport = new Transporter(Warehouse.CENTRAL_WAREHOUSE, acquiredGoods);
        transport.delivering();
        this.completed = true;
    }
}
