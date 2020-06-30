package org.kodvabt.warehouse.manager.goods;

import java.util.UUID;


public class GoodsBuilder {
    private String name;
    private String category;
    private String producer;
    private int price;
    private int count;

    public static GoodsBuilder fromGoods(Goods oldGoods) {
        return new GoodsBuilder().withName(oldGoods.getName())
                .withCategory(oldGoods.getCategory())
                .withProducer(oldGoods.getProducer())
                .withCount(oldGoods.getCount());
    }


    public GoodsBuilder withName(String name) {
        this.name = name.toLowerCase();
        return this;
    }

    public GoodsBuilder withCategory(String category) {
        this.category = category.toLowerCase();
        return this;
    }

    public GoodsBuilder withProducer(String producer) {
        this.producer = producer.toLowerCase();
        return this;
    }

    public GoodsBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public GoodsBuilder withCount(int count) {
        this.count = count;
        return this;
    }

    public Goods build() {
        UUID id = UUID.fromString(name);
        return new Goods(id, name, category, producer, price, count);
    }
}