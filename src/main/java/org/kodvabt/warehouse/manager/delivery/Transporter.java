package org.kodvabt.warehouse.manager.delivery;

import org.kodvabt.warehouse.manager.goods.Goods;

import java.util.ArrayList;
import java.util.List;

public class Transporter implements Observable {
    private final TransporterType transporterType;
    private final Warehouse source;
    private final List<Goods> warehouseGoods;
    private final List<Observer> observers;

    public Transporter(Warehouse source, List<Goods> goodsToBeDelivered) {
        this.transporterType = TransporterType.getProperTransporter(goodsToBeDelivered.stream().mapToInt(Goods::getCount).sum());
        this.source = source;
        this.warehouseGoods = goodsToBeDelivered;
        this.observers = new ArrayList<>();
    }

    public TransporterType getTransporterType() {
        return transporterType;
    }

    public Warehouse getSource() {
        return source;
    }


    public List<Goods> getWarehouseGoods() {
        return warehouseGoods;
    }

    public void delivering() {
        warehouseGoods.forEach(source::getItemFromWarehouse);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }
}
