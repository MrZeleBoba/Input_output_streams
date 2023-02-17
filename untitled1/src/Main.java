
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] count = new int[3];

        int sumProduct = 0;

        System.out.println("Список товаров для покупки:");

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + "." + products[i] + "-" + prices[i] + " руб/шт");
        }


        while (true) {
            System.out.println("Выберите товар и колличество или введите end");
            try {
                String input = scanner.nextLine();
                if ("end".equals(input)) {
                    break;
                }

                String[] parts = input.split(" ");

                if (parts.length != 2) {
                    System.out.println("Ошибка ввода:нужно ввести 2 значения через пробел");
                    continue;
                }

                int productNumber = Integer.parseInt(parts[0]) - 1;
                if (Integer.parseInt(parts[0]) < 1 || Integer.parseInt(parts[0]) > 3) {
                    System.out.println("Ошибка ввода номера продукта:значение должно соответствовать номеру продукта от 1 до 3");
                    continue;
                }


                int productCount = Integer.parseInt(parts[1]);
                count[productNumber] = count[productNumber] + productCount;

            } catch (NumberFormatException t) {
                System.out.println("Введено некорректное значение");

            }
        }

        System.out.println("Ваша корзина:");

        for (int i = 0; i < products.length; i++) {
            if (count[i] != 0) {
                int currentPrice = prices[i] * count[i];
                System.out.println("Продукт: " + products[i] + ", " + "Количество: " + count[i] + ", " + "Стоимость: " + prices[i] + " руб/шт," + "В сумме: " + currentPrice + "руб");
                sumProduct += currentPrice;
            }
        }
        System.out.println("Итого: " + sumProduct + " руб");
    }
}
