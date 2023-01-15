import java.util.Scanner;

public class Cashier {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Type your order type: Classic, DeLux or Indi:  ");
        String orderCreator = scr.nextLine();

        AbstrOrderProcess order = CreateOrder.getOrder(orderCreator);

        burgerCreator(orderCreator, order);

    }

    private static void burgerCreator(String orderCreator, AbstrOrderProcess order) {
        if (orderCreator.equalsIgnoreCase("DeLux")) {
            AbstrOrderProcess order2 = CreateOrder.getOrder("DeLux");
            order2 = (AbstrOrderProcess) order.getOrder("deLux");
        }

        if (orderCreator.equalsIgnoreCase("Classic")) {
            AbstrOrderProcess order3 = CreateOrder.getOrder("Classic");
            order3 = (AbstrOrderProcess) order.getOrder("Classic");
        }

        if (orderCreator.equalsIgnoreCase("Indi")) {
            AbstrOrderProcess order4 = CreateOrder.getOrder("Indi");
            System.out.println("Choose a hambi, drink,"
                    + " side-dish you want to grab ");
            order4 = (AbstrOrderProcess) order.getOrder("Indi");

            if (orderCreator.equalsIgnoreCase("Hambi")) {
                Order order1 = order.getOrder("HAMBI");

            } else if (orderCreator.equalsIgnoreCase("drink")) {
                Order drink = order.getOrder("DRINK");

            } else if (orderCreator.equalsIgnoreCase("SIDE")) {
                Order sideDish = order.getOrder("SIDE");
            }

        }
    }
}


