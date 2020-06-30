package org.kodvabt.warehouse.manager.delivery;

import org.kodvabt.warehouse.manager.goods.Goods;
import org.kodvabt.warehouse.manager.goods.GoodsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Warehouse {
    public static final Warehouse CENTRAL_WAREHOUSE = new Warehouse("Central", "here", new HashMap<>());

    private final UUID warehouseId;
    private final String name;
    private final String location;
    private final int distance; //lower value is better
    private final Map<UUID, Goods> amountOfItems;

    public Warehouse(String name, String location, Map<UUID, Goods> amountOfItems) {
        this.warehouseId = UUID.fromString(name);
        this.name = name;
        this.location = location;
        this.amountOfItems = amountOfItems;
        this.distance = (int) (Math.random() * 10) + 1;
    }

    public String getName() {
        return name;
    }

    public UUID getWarehouseId() {
        return warehouseId;
    }

    public String getLocation() {
        return location;
    }

    public int getDistance() {
        return distance;
    }

    public boolean hasEnoughItem(Goods goods) {
        return amountOfItems.containsKey(goods.getId()) &&
                amountOfItems.get(goods.getId()).getCount() >= goods.getCount();
    }

    public void getItemFromWarehouse(Goods goods) {
        Goods oldGoods = amountOfItems.get(goods.getId());
        int newAmount = oldGoods.getCount() - goods.getCount();
        Goods newGoods = GoodsBuilder.fromGoods(oldGoods).withCount(newAmount).build();
        amountOfItems.put(goods.getId(), newGoods);
    }
}
