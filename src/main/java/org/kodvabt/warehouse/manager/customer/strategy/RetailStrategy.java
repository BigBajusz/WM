package org.kodvabt.warehouse.manager.customer.strategy;

public class RetailStrategy implements CustomerStrategy {

    @Override
    public int getMaxAffordableDebt() {
        return 5000000;
    }

    @Override
    public int getMaxAffordableAmount() {
        return 1000;
    }
}
