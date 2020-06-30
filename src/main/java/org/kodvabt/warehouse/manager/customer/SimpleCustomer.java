package org.kodvabt.warehouse.manager.customer;

import org.kodvabt.warehouse.manager.customer.strategy.SimpleStrategy;

public class SimpleCustomer extends AbstractCustomer {

    public SimpleCustomer(String name, String address, Integer budget)
    {
        super(name, address, budget, new SimpleStrategy());
    }


}
