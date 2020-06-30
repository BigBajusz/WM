package org.kodvabt.warehouse.manager.customer;

import org.kodvabt.warehouse.manager.Order;
import org.kodvabt.warehouse.manager.customer.strategy.CustomerStrategy;
import org.kodvabt.warehouse.manager.delivery.OrderHandler;
import org.kodvabt.warehouse.manager.goods.Goods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public abstract class AbstractCustomer {
    private final UUID customerId;
    private final String name;
    private String address;
    private Integer balance;
    private final CustomerStrategy strategy;
    private final List<Order> submittedOrders;

    public AbstractCustomer(String name, String address, Integer balance, CustomerStrategy strategy) {
        this.customerId = UUID.fromString(strategy.getClass().getSimpleName() + name);
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.strategy = strategy;
        this.submittedOrders = new ArrayList<>();
    }

    public void createOrder(Goods... goods) {
        int cost = Arrays.stream(goods).mapToInt(Goods::getFullPrice).sum();
        Order order = new Order(customerId, Arrays.asList(goods), address, strategy, cost);
        submittedOrders.add(order);
    }

    public void submitOrder(Order order) {
        if (hasEnoughBalance(order)) {
            balance -= order.getCost();
            OrderHandler.SINGLETON_INSTANCE.handleOrder(order);
        }
    }

    private boolean hasEnoughBalance(Order order) {
        int availableBalance = balance - order.getCost();
        return availableBalance >= 0;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getBalance() {
        return balance;
    }

    public CustomerStrategy getStrategy() {
        return strategy;
    }

    public List<Order> getSubmittedOrders() {
        return submittedOrders;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addBalance(int extra)
    {
        this.balance+=extra;
    }
}
