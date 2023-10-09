package vehicles;

public class Truck extends Vehicle {
    private int capacity;

    public Truck(int power, String manufacturer, int capacity) {
        super(power, manufacturer);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                ", power=" + power +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}