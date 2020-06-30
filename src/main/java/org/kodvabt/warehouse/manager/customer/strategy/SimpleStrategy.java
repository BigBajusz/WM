package org.kodvabt.warehouse.manager.customer.strategy;

public class SimpleStrategy implements CustomerStrategy {

    @Override
    public int getMaxAffordableDebt() {
        return 500000;
    }

    @Override
    public int getMaxAffordableAmount() {
        return 30;
    }
}
