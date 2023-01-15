public class ClassicMenu extends AbstrOrderProcess {

    private SideDish sideDish;
    private SoftDrink softDrink;
    private double price;

    public ClassicMenu() {
        this.sideDish =new SideDish() ;
        this.softDrink = new SoftDrink();
        this.price = 6.0;
    }

    @Override
    Order getOrder(String type) {
        System.out.println("You go for a our Classic Burger Menu choose a drink to it: ");
        softDrink.create();
        System.out.println("Time to choose your side-dish to your classic menu: ");
        sideDish.create();
        finalDisplayTextForClassic();
        return null;
    }

    @Override
    double calculatePrice() {
        return getPrice() + softDrink.calculatePrice() + sideDish.calculatePrice();
    }

    public void finalDisplayTextForClassic(){
        System.out.println("Your Classic menu with "+ sideDish.getName()
                +", size "+ sideDish.getSize().toUpperCase()
                +" and "
                +softDrink.getName()+ ", size "
                + softDrink.getSize().toUpperCase()
                + " goes for: " + calculatePrice());
    }

    public double getPrice() {
        return price;
    }

}
