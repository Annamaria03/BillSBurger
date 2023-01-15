public class DeLuxMenu extends AbstrOrderProcess {
    private SideDish sideDish;
    private SoftDrink softDrink;
    private double price;

    public DeLuxMenu() {
        this.sideDish =new SideDish() ;
        this.softDrink = new SoftDrink();
        this.price = 8.0;
    }

    @Override
    Order getOrder(String type) {
        System.out.println("You go for a our magical DeLux Burger Menu choose a drink to it: ");
        softDrink.create();
        System.out.println("Time to choose your side-dish to your deLux menu: ");
        sideDish.create();
        finalDisplayTextForDelux();
        return null;
    }

    public double getPrice() {
        return price;
    }

    @Override
    double calculatePrice() {
        return getPrice() + softDrink.calculatePrice() + sideDish.calculatePrice();
    }

    public void finalDisplayTextForDelux(){
        System.out.println("Your DeLux menu with "+ sideDish.getName()
                +", size "+ sideDish.getSize().toUpperCase()
                +" and "
        +softDrink.getName()+ ", size "
        + softDrink.getSize().toUpperCase()
        + " goes for: " + calculatePrice());

    }
}
