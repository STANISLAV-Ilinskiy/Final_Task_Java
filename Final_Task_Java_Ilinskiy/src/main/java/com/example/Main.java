package main.java.com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();

        // Добавление ноутбуков в магазин
        store.addLaptop(new Laptop("Dell", 8, 512, "Windows 10", "Black"));
        store.addLaptop(new Laptop("HP", 16, 1024, "Windows 11", "Silver"));
        store.addLaptop(new Laptop("Apple", 8, 256, "macOS", "Gray"));
        store.addLaptop(new Laptop("Asus", 4, 512, "Windows 10", "Black"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Главное меню:");
            System.out.println("1 - Фильтровать ноутбуки");
            System.out.println("2 - Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    FilterLaptops.filterLaptops(store.getLaptops());
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        System.out.println("Выход из программы...");
    }

}
