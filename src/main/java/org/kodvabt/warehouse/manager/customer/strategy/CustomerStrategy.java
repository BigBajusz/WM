package org.kodvabt.warehouse.manager.customer.strategy;

public interface CustomerStrategy {
    int getMaxAffordableDebt();

    int getMaxAffordableAmount();
}
