import java.util.*;

public class Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(new Address("Россия", "Москва"), 100);
        costPerAddress.put(new Address("Россия", "Уфа"), 110);
        costPerAddress.put(new Address("Россия", "Тула"), 120);
        costPerAddress.put(new Address("Казахстан", "Астана"), 130);
        costPerAddress.put(new Address("Беларусь", "Минск"), 150);

        int total = 0;
        Set<String> countries = new HashSet<>();
        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            if ("end".equals(country)) {
                break;
            }
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            System.out.print("Введите вес (в кг): ");
            int weight = Integer.parseInt(scanner.nextLine());

            Address address = new Address(country, city);
            if (costPerAddress.containsKey(address)) {
                int currentPrice = weight * costPerAddress.get(address);
                total += currentPrice;
                countries.add(country);
                System.out.printf("Стоимость доставки составит :%d руб.\n", currentPrice);
                System.out.printf("Общая стоимость всех доставок :%d руб.\n", total);
                System.out.printf("Количество обслуженных стран :%d \n", countries.size());
            } else {
                System.out.println("Доставки нет");
            }
        }


    }
}
