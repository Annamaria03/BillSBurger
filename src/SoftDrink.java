import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftDrink implements Order {
    private String size;
    private double price;
    private Object name; //for hashKeynaming,
    private LinkedHashMap<String, Double> drinkList;

    public SoftDrink() {
        this.size = size;
        this.name = name;
        this.price = price;
        this.drinkList = new LinkedHashMap<>();
    }

    @Override
    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: Orange, Apple and Wild ");
        chooseJuice(scanner.nextLine());
        System.out.println("Please type L for large, M for medium and S for small size: ");
        setSize(scanner.nextLine());
        setPrice(getSize());
        drinkList.put((String)getName(), getPrice());
        System.out.println("Your " + getName() + " goes for: " + getPrice());

    }

    @Override
    public double calculatePrice() {
        return drinkList.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public Object chooseJuice(String name) {
        if (name.equalsIgnoreCase("Orange")) {
            setName("Orange juice");
        } else if (name.equalsIgnoreCase("Apple")) {
            setName("Apple juice");
        } else if (name.equalsIgnoreCase("wild")) {
            setName("Wild-berry juice");
        } else
            throw new IllegalStateException("Unexpected value" + name);
        return name;
    }

    public Object setName(String name) {
       return this.name = name;
    }

    public Object getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
        if (size.equalsIgnoreCase("L")) {
            System.out.println("You've chosen a large: " + getName());
        } else if (size.equalsIgnoreCase("M")) {
            System.out.println("You've chosen a medium: " + getName());
        } else if (size.equalsIgnoreCase("S")) {
            System.out.println("You've chosen a small: " + getName());
        } else
            throw new IllegalStateException("Unexpected value: " + size);

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String size) {
        if (size.equalsIgnoreCase("L")) {
            this.price = 2.0;
        }
        if (size.equalsIgnoreCase("M")) {
            this.price = 1.5;
        }
        if (size.equalsIgnoreCase("S")) {
            this.price = 1.25;
        }
    }
    //for the case of more..S
    public LinkedHashMap<String, Double> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(LinkedHashMap<String, Double> drinkList) {
        this.drinkList = drinkList;
    }
}
