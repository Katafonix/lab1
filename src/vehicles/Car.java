package vehicles;

public class Car extends Vehicle {
    private int nDoors;
    private int maxSpeed;

    public Car(int power, String manufacturer, int nDoors, int maxSpeed) {
        super(power, manufacturer);
        this.nDoors = nDoors;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nDoors=" + nDoors +
                ", maxSpeed=" + maxSpeed +
                ", power=" + power +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}