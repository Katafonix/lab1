import vehicles.Vehicle;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> lst = new List<>();
        String fileName = "CommandsList.txt";
        lst.readFile(fileName);
    }
}