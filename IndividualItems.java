import java.util.*;

public class IndividualItems extends AbstrOrderProcess {
    private Hamburger hamburger;
    private SoftDrink softDrink = new SoftDrink();
    private SideDish sideDish = new SideDish();
    private boolean isHambi, isDrink, isSide;
    private LinkedHashMap<String, Object> orderListBurgersAndExtras;        //for individual naming or code duplication!!! be aware
    private LinkedHashMap<Object, Double> trayContent;

    public IndividualItems() {
        this.hamburger = new Hamburger();
        this.softDrink = new SoftDrink();
        this.sideDish = new SideDish();
        this.orderListBurgersAndExtras = new LinkedHashMap<>();
        this.trayContent = new LinkedHashMap<>();

    }

    //try catch!!
    // Hash put each burger and name the value type+i-> hambi0 {getExtras()} DONE
    //create remove order
    @Override
    public Order getOrder(String type) {
        Scanner scr = new Scanner(System.in);
        int counter = 0;
        do {
            openingDisplayTxt();
            type = scr.nextLine();      //mind to create utils class for scanners
            counter++;
            if (type.equalsIgnoreCase("HAMBI")) {
                setHambi(true);
                hamburger.create();
                hamburger.getExtras();
                setOrderListBurgerAndExtras(type, counter);
                orderListBurgerAndExtrasDisplayTxt();
                individualTrayContentCollector(type, counter);
                trayContentAndPriceDisplayTxt();

            } else if (type.equalsIgnoreCase("DRINK")) {
                setDrink(true);
                softDrink.create();
                individualTrayContentCollector(type, counter);
                softDrinkAddedToTrayDisplayTxt();

            } else if (type.equalsIgnoreCase("SIDE")) {
                setSideDish(true);
                sideDish.create();
                individualTrayContentCollector(type, counter);
                sideDishAddedToTrayDisplayTxt();

            } else if (type.equalsIgnoreCase("END")) {
                endMsgTrayContent();
                getOrderListBurgersAndExtras();
                subtotalMsg();
                finalMsg();
                System.out.println(calculatePrice());
                break;

            } else
                throw new IllegalStateException("Unexpected value: " + type.toUpperCase());

        } while (!type.equalsIgnoreCase("End"));

        return null;
    }

    public static void openingDisplayTxt() {
        System.out.println("Let's taylor further that order," +
                "\n" + "Maybe an extra DRINK, SIDE dish or maybe more HAMBI could make your dream better?!"
                + "\n" + "+ If so just type the magic words! "
                + "\n" + "remember to hit an 'END' to QUIT");
    }

    public void setOrderListBurgerAndExtras(String type, int counter) {
        orderListBurgersAndExtras.put((type + counter), hamburger.getExtras());
    }

    public void orderListBurgerAndExtrasDisplayTxt() {
        System.out.println("This is the orderList from hamburger and its extras: " + getOrderListBurgersAndExtras()
                + " for: " + hamburger.calculatePrice());

    }

    public LinkedHashMap<Object, Double> individualTrayContentCollector(String type, int counter) {
        if (isHambi) {
            trayContent.put(hamburger.setName((type + counter)),
                    hamburger.calculatePrice());
        } else if (isDrink) {
            trayContent.put(softDrink.setName((type + counter)), softDrink.calculatePrice());

        } else if (isSide) {
            trayContent.put(sideDish.setName((type + counter)), sideDish.calculatePrice());

        }
        return trayContent;

    }

    public void trayContentAndPriceDisplayTxt() {
        System.out.println("This is on the tray " + getTrayContent().keySet() + " for: " + calculatePrice());
    }

    @Override
    double calculatePrice() {
        return hamburger.calculatePrice() + (getDrink().calculatePrice()) + (getSideDish().calculatePrice());

    }
    // think...
    public double traySum() {
        return getTrayContent().values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public void softDrinkAddedToTrayDisplayTxt() {
        System.out.println("Your drink added to your order: " + softDrink.getName() + " size " + softDrink.getSize().toUpperCase()
                + " for " + softDrink.calculatePrice());
    }

    public void sideDishAddedToTrayDisplayTxt() {
        System.out.println("Your side-dish added to your order: " + sideDish.getName() + " size " + sideDish.getSize().toUpperCase()
                + " for " + softDrink.calculatePrice());
    }

    public SoftDrink getDrink() {
        return softDrink;
    }

    public SideDish getSideDish() {
        return sideDish;
    }

    public void endMsgBurgerToppings() {
        //for some weired reason I had to introduce x..
        double x = hamburger.getExtraIngredientsSum();
        System.out.println("Burger toppings total: " + x);
    }

    public void subtotalMsg() {
        if (isHambi) {
            System.out.println("Burgers goes for: " + hamburger.calculatePrice());
            endMsgBurgerToppings();
        }
        if (isDrink) {
            System.out.println("Drinks goes for: " + softDrink.calculatePrice());
        }
        if (isSide) {
            System.out.println("Side-dish goes for: " + sideDish.calculatePrice());
        }


    }

    public void endMsgTrayContent() {
        System.out.println("Your meal is: " + getTrayContent().keySet());
    }

    public void finalMsg() {
        System.out.println("Total: ");
    }

    public HashMap<Object, Double> getTrayContent() {
        return trayContent;
    }

    public LinkedHashMap<String, Object> getOrderListBurgersAndExtras() {
        return orderListBurgersAndExtras;
    }

    public void setHambi(boolean hambi) {
        isHambi = hambi;
    }

    public void setDrink(boolean drink) {
        isDrink = drink;
    }

    public void setSideDish(boolean side) {
        isSide = side;
    }

}
