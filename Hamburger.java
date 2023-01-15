import java.util.LinkedHashMap;
import java.util.Scanner;

public class Hamburger implements Order {
    private Double basePrice;
    private Double cheesePrice, picklePrice, whGrainPrice;
    private String wholegrain, cheese, pickle;
    private LinkedHashMap<String, Double> extras;
    private Object name;

    public Hamburger() {
        this.basePrice = 5.0;
        this.cheesePrice = 1.0;
        this.picklePrice = 0.5;
        this.whGrainPrice = 0.75;
        this.extras = new LinkedHashMap<String, Double>();

    }

    @Override
    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wholegrain bun Yes or No: ");
        chooseWholegrainBun(scanner.nextLine());
        setExtras(getWholegrain(),getWhGrainPrice());
        System.out.println("Cheese Yes or No: ");
        chooseCheeseTopping(scanner.nextLine());
        setExtras(getCheese(),getCheesePrice());
        System.out.println("Pickle? Yes, or No: ");
        choosePickleTopping(scanner.nextLine());
        setExtras(getPickle(),getPicklePrice());

    }

    public void choosePickleTopping(String pickle){
        if (pickle.equalsIgnoreCase("YES")) {
            setPickle("Juicy pickles");
        } else if (pickle.equalsIgnoreCase("NO")) {
            setPicklePrice(0.0);
            setPickle("No extra pickles");
        }
    }

    public void chooseCheeseTopping(String cheese) {
        if (cheese.equalsIgnoreCase("YES")) {
            setCheese("Melted cheese");
        } else if (cheese.equalsIgnoreCase("NO")) {
            setCheesePrice(0.0);
            setCheese("No extra cheese");
        }
    }

    public void chooseWholegrainBun(String wh) {
        if (wh.equalsIgnoreCase("YES")) {
            setWholegrain("Wholegrain bun");
        } else if (wh.equalsIgnoreCase("NO")) {
            setWhGrainPrice(0.0);
            setWholegrain("Regular bun");
            System.out.println("Regular bun is on the way to become a deliciousness for " + basePrice);
        }
    }

    @Override
    public double calculatePrice() {
        return getPrice() + getExtraIngredientsSum();
    }

    public double getExtraIngredientsSum() {
        return getExtras().values().stream()
                .mapToDouble(Double::doubleValue).sum();
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheesePrice(double cheesePrice) {
        this.cheesePrice = cheesePrice;
    }

    public double getCheesePrice() {
        return cheesePrice;
    }

    public void setPickle(String pickle) {
        this.pickle = pickle;
    }

    public String getPickle() {
        return pickle;
    }

    public void setPicklePrice(double picklePrice) {
        this.picklePrice = picklePrice;
    }

    public double getPicklePrice() {
        return picklePrice;
    }

    public void setWholegrain(String wh) {
        this.wholegrain = wh;
    }

    public String getWholegrain() {
        return wholegrain;
    }

    public void setWhGrainPrice(double whGrainPrice) {
        this.whGrainPrice = whGrainPrice;
    }

    public double getWhGrainPrice() {
        return whGrainPrice;
    }

    public double getPrice() {
        return basePrice;
    }

    //for hash key individual naming at IndividualItems
    public Object setName(String name) {
        return this.name = name;
    }

    public Object getName() {
        return name;
    }

    public void setExtras(String type, Double price) {
        extras.put(type, price);
    }

    //collect extra ingredients in HashMap
    public LinkedHashMap<String, Double> getExtras() {
        return extras;
    }














}
