import vehicles.Bus;
import vehicles.Car;
import vehicles.Truck;

public class FactoryObjects<T> {
    public T create(String[] parameters) {
        String objectType = parameters[1];
        int power = Integer.parseInt(parameters[2]);
        String manufacturer = parameters[3];

        if (!Character.isUpperCase(manufacturer.charAt(0)) || !manufacturer.chars().allMatch(Character::isLetter))
            throw new RuntimeException("Некорректный параметр manufacturer");

        if (objectType.equals("Truck") && parameters.length >= 5) {
            int capacity = Integer.parseInt(parameters[4]);
            return (T) new Truck(power, manufacturer, capacity);
        } else if (objectType.equals("Bus") && parameters.length >= 5) {
            int capacity = Integer.parseInt(parameters[4]);
            return (T) new Bus(power, manufacturer, capacity);
        } else if (parameters.length >= 6) {
            int nDoors = Integer.parseInt(parameters[4]);
            if (!(nDoors >= 2 && nDoors <= 5))
                throw new RuntimeException("Некорректный параметр nDoors, параметр должен быть в диапозоне от 2 до 5");

            int maxSpeed = Integer.parseInt(parameters[5]);
            return (T) new Car(power, manufacturer, nDoors, maxSpeed);
        } else {
            throw new RuntimeException("Некорректные параметры объекта");
        }
    }
}
