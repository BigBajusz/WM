package org.kodvabt.warehouse.manager.customer;

import org.kodvabt.warehouse.manager.customer.strategy.RetailStrategy;

public class RetailCustomer extends AbstractCustomer {

    public RetailCustomer(String name, String address, Integer budget)
    {
        super(name, address, budget, new RetailStrategy());
    }

}
