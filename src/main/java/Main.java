import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    NumberOfPeople.printNumberOfPeople();
    }
}
class NumberOfPeople {
    static void printNumberOfPeople() {
        int num;
        while (true) {
            System.out.println("На какое количество людей необходимо разделить счет? ");
            num = Main.scanner.nextInt();
            Main.scanner.nextLine();

            if (num <= 1) {
                System.out.println("Пук-с, что-то не так с количеством людей, попробуйте еще раз!");
            } else {
                break;
            }
        }
        listOfDishes(num);
    }
    static void listOfDishes(int number){
        float totalPrice = 0.00f;
        StringBuilder productList = new StringBuilder();

        while (true) {
            System.out.println("Введите название товара: ");
            String dish = Main.scanner.nextLine();
            System.out.println("Введите стоимость товара: ");
            float cost = Float.parseFloat(Main.scanner.nextLine());

            totalPrice += cost;
            productList.append(dish).append(": ").append(cost).append(" руб.\n");

            System.out.println("Товар успешно добавлен!");
            System.out.println("Хотите ли вы добавить еще один товар?");

            String choice = Main.scanner.nextLine();

            if (choice.equalsIgnoreCase("завершить")) {
                break;
            }
        }
        System.out.println("Добавленные товары:");
        System.out.println(productList.toString());

        System.out.println("Сумма, которую должен заплатить каждый человек:");
        float onePrice = totalPrice / number;
        if (onePrice<2) {
            System.out.printf("%.2f рубль", onePrice);
        } else if (onePrice >= 2 && onePrice <= 4) {
            System.out.printf("%.2f рубля", onePrice);
        } else {
            System.out.printf("%.2f рублей", onePrice);
        }
    }
}



