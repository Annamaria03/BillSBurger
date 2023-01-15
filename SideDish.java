import java.util.LinkedHashMap;
import java.util.Scanner;

public class SideDish implements Order {
    private String size;
    private double price;
    private Object name; //for hashKey naming, think in creating a complete class for it...
    private LinkedHashMap<String, Double> sideDishList;

    public SideDish() {
        this.size = size;
        this.name = name;
        this.price = price;
        this.sideDishList = new LinkedHashMap<>();
    }

    //think to use Reader class
    @Override
    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: Fries or Fresh ");
        chooseSideDishType(scanner.nextLine());
        System.out.println("Please type L for large, M for medium and S for small size: ");
        setSize(scanner.nextLine().toUpperCase());
        setPrice(getSize());
        sideDishList.put((String) getName(), getPrice());
        System.out.println("Your " + getName() + " goes for: " + getPrice());

    }

    @Override
    public double calculatePrice() {
        return sideDishList.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public Object chooseSideDishType(String name) {
        if (name.equalsIgnoreCase("Fries")) {
            setName("Crispy fries");
        } else if (name.equalsIgnoreCase("Fresh")) {
            setName("Fresh salad");
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
            this.price = 2.5;
        }
        if (size.equalsIgnoreCase("M")) {
            this.price = 2.25;
        }
        if (size.equalsIgnoreCase("S")) {
            this.price = 2.0;
        }
    }
    //for the case of more..
    public LinkedHashMap<String, Double> getSideDishList() {
        return sideDishList;
    }

    public void setSideDishList(LinkedHashMap<String, Double> drinkList) {
        this.sideDishList = drinkList;
    }

}
