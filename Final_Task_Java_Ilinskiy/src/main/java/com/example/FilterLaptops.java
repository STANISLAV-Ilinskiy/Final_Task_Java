package main.java.com.example;

import java.util.*;

public class FilterLaptops {
    public static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> criteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Вернуться в главное меню");

        int criterion = scanner.nextInt();
        scanner.nextLine(); // Использовать новую строку

        if (criterion == 5) {
            return;
        }

        switch (criterion) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ: ");
                int minRam = scanner.nextInt();
                criteria.put("ram", minRam);
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД: ");
                int minHdd = scanner.nextInt();
                criteria.put("hdd", minHdd);
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                String os = scanner.nextLine();
                criteria.put("os", os);
                break;
            case 4:
                System.out.print("Введите цвет: ");
                String color = scanner.nextLine();
                criteria.put("color", color);
                break;
            default:
                System.out.println("Неверный критерий");
                return;
        }

        Set<Laptop> filteredLaptops = new HashSet<>(laptops);
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            switch (entry.getKey()) {
                case "ram":
                    filteredLaptops.removeIf(laptop -> laptop.getRam() < (int) entry.getValue());
                    break;
                case "hdd":
                    filteredLaptops.removeIf(laptop -> laptop.getHdd() < (int) entry.getValue());
                    break;
                case "os":
                    filteredLaptops.removeIf(laptop -> !laptop.getOs().equalsIgnoreCase((String) entry.getValue()));
                    break;
                case "color":
                    filteredLaptops.removeIf(laptop -> !laptop.getColor().equalsIgnoreCase((String) entry.getValue()));
                    break;
            }
        }

        System.out.println("Ноутбуки, соответствующие критериям:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}
