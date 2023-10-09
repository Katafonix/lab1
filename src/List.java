import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class List<T> {
    private Node<T> head;
    private int size = 0;

    private static class Node<T> {
        Node<T> next;
        T data;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    void push(T data) {
        if (head == null) {
            head = new Node<>(data);
            head.next = head;
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = new Node<>(data, head);
        }
        size++;
    }

    int getSize() {
        return size;
    }

    <U> void remove(U data) {
        if (isEmpty()) throw new RuntimeException("Список пуст, нельзя удалить элемент");

        Node<T> previous = null;
        Node<T> current = head;

        do {
            if (current.data.equals(data)) {
                if (current == head) head = current.next;
                else previous.next = current.next;
                size--;
            }
            previous = current;
            current = current.next;

        } while (current != head);
    }

    void print() {
        if (isEmpty()) System.out.println("Список пуст");
        else {
            Node<T> current = head;
            do {
                System.out.println(current.data);
                current = current.next;
            } while (current != head);
        }
    }

    void readFile(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                processCommand(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    boolean isEmpty() {
        return getSize() == 0;
    }

    void processCommand(String line) {
        String[] parameters = line.split(" ");
        String command = parameters[0];

        try {
            switch (command) {
                case "ADD" -> processAddCommand(parameters);
                case "REM" -> processRemoveCommand(parameters);
                case "PRINT" -> print();
                default -> throw new RuntimeException("Неизвестная команда: " + command);
            }
        } catch (RuntimeException e) {
            System.err.println("Ошибка при выполнении команды: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка при выполнении команд: " + e.getMessage());
        }
    }

    private void processAddCommand(String[] parameters) {
        FactoryObjects<T> factoryObjects = new FactoryObjects<>();
        push(factoryObjects.create(parameters));
    }

    private void processRemoveCommand(String[] parameters) {
        if (parameters.length != 2) throw new RuntimeException("Некорректное количество параметров для команды REM");
        String parameter = parameters[1];
        remove(parameter);
    }
}