package org.kodvabt.warehouse.manager.customer.strategy;

public class WholesaleStrategy implements CustomerStrategy {

    @Override
    public int getMaxAffordableDebt() {
        return 20000000;
    }

    @Override
    public int getMaxAffordableAmount() {
        return Integer.MAX_VALUE;
    }
}
