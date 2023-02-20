import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Basket implements Serializable {
    private Product[] products;
    private int sumProduct = 0;

    public Basket(Product[] products) {
        this.products = products.clone();
    }

    public void addToCart(int productNum, int amount) {
        products[productNum].changeItemInBasket(amount);
        sumProduct += products[productNum].getPrice() * amount;
    }

    public void printGoodsList() {

        System.out.println("Список товаров для покупки:");

        int currentValue;
        sumProduct = 0;
        for (int i = 0; i < products.length; i++) {
            currentValue = products[i].getInBasket() * products[i].getPrice();
            sumProduct += currentValue;
            System.out.println((i + 1) + "." + products[i].getName() + "-" + products[i].getPrice() + " руб/шт - Кол-во:" + products[i].getInBasket() + " - В сумме:" + currentValue + " руб.");

        }
        System.out.println("ИТОГО Товаров в корзине на " + sumProduct + " рублей");

    }

    public void printCart() {
        System.out.println("Ваша корзина:");

        for (int i = 0; i < products.length; i++) {
            if (products[i].getInBasket() > 0) {
                int currentPrice = products[i].getInBasket() * products[i].getPrice();
                System.out.println("Продукт: " + products[i].getName() + ", Количество: " + products[i].getInBasket() + ", Стоимость: " + products[i].getPrice() + " руб/шт," + "В сумме: " + currentPrice + "руб");

            }

        }
        System.out.println("Итого: " + sumProduct + " руб");

    }

    public void saveBin(File file) throws IOException {
        try {
            var fos = new FileOutputStream(file);
            var oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public static Basket loadFromBinFile(File file) throws IOException, ClassNotFoundException {
        var fis = new FileInputStream(file);
        var ois = new ObjectInputStream(fis);
        return (Basket) ois.readObject();
    }
}