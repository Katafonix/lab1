package vehicles;

import java.util.Objects;

public abstract class Vehicle {
    protected int power;
    protected String manufacturer;

    protected Vehicle(int power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof String) {
            return Objects.equals(manufacturer, o);
        }
        return  false;
    }
}