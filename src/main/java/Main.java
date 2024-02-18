import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        NumberOfPeople.printNumberOfPeople();
    }
}
class NumberOfPeople {
    static void printNumberOfPeople() {
        int num = 0;
        while (num <= 1) {
            System.out.println("На какое количество людей необходимо разделить счет? ");
            if (Main.scanner.hasNextInt()) {
                num = Main.scanner.nextInt();
                Main.scanner.nextLine();
                if (num <= 1) {
                    System.out.println("Пук-с, что-то не так с количеством людей, попробуйте еще раз!");
                    Main.scanner.nextLine();
                }
            } else {
                System.out.println("Пожалуйста, введите целое число.");
                Main.scanner.nextLine();
            }
        }
        listOfDishes(num);
    }

    static void listOfDishes(int number) {
        float totalPrice = 0.00f;
        float cost = 0.00f;
        StringBuilder productList = new StringBuilder();

        while (true) {
            String dish = "";
            System.out.println("Введите название товара: ");
            //Main.scanner.nextLine();
            while (true) {
                dish = Main.scanner.nextLine();
                //System.out.println("Вы ввели: " + dish);
                if (dish.isEmpty()) {
                    System.out.println("Название товара не может быть пустым. Пожалуйста, введите название товара.");
                } else {
                    break;
                }
            }

            System.out.println("Введите стоимость товара: ");
            while (true) {
                if (Main.scanner.hasNextFloat()) {
                    cost = Main.scanner.nextFloat();
                    if (cost <= 0) {
                        System.out.println("Стоимость товара должна быть положительным числом. Пожалуйста, введите корректное значение.");
                        Main.scanner.nextLine();
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Введите корректную стоимость товара.");
                    Main.scanner.nextLine();
                }
            }
            Main.scanner.nextLine();

            totalPrice += cost;
            productList.append(dish).append(": ").append(cost).append(" руб.\n");

            System.out.println("Товар успешно добавлен!");
            System.out.println("Хотите ли вы добавить еще один товар? Введите 'завершить' чтобы подсчитать сумму товаров.");
            String choice = Main.scanner.nextLine();

            if (choice.trim().equalsIgnoreCase("завершить")) {
                break;
            }
        }
        System.out.println("Добавленные товары:");
        System.out.println(productList);

        System.out.println("Сумма, которую должен заплатить каждый человек:");
        float onePrice = totalPrice / number;
        PriceFormatter.printPrice(onePrice);
    }
}

class PriceFormatter {
    public static void printPrice(float price) {
        if (price < 2) {
            System.out.printf("%.2f рубль", price);
        } else if (price >= 2 && price <= 4) {
            System.out.printf("%.2f рубля", price);
        } else {
            System.out.printf("%.2f рублей", price);
        }
    }
}

