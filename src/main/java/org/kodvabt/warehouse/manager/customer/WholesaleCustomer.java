package org.kodvabt.warehouse.manager.customer;

import org.kodvabt.warehouse.manager.customer.strategy.WholesaleStrategy;

public class WholesaleCustomer extends AbstractCustomer{

    public WholesaleCustomer(String name, String address, Integer budget)
    {
        super(name, address, budget, new WholesaleStrategy());
    }

}
