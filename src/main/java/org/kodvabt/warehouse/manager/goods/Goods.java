package org.kodvabt.warehouse.manager.goods;

import java.util.UUID;

public class Goods {
    private final UUID id;
    private final String name;
    private final String category;
    private final String producer;
    private final int price;
    private final int count;

    Goods(UUID id, String name, String category, String producer, int price, int count) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.price = price;
        this.count = count;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getProducer() {
        return producer;
    }

    public int getPricePerPiece() {
        return price;
    }

    public int getFullPrice() {
        return price * count;
    }

    public int getCount() {
        return count;
    }
}
