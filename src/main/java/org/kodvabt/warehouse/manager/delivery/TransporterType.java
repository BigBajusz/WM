package org.kodvabt.warehouse.manager.delivery;

public enum TransporterType {
    TRUCK, VAN, CAR;

    public static TransporterType getProperTransporter(int amount) {
        if (amount > 15) {
            return TRUCK;
        }
        if (amount > 5) {
            return VAN;
        }
        return CAR;
    }
}
