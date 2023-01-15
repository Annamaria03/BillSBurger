import java.util.Scanner;

public class CreateOrder {
    private IndividualItems indi;
    private ClassicMenu classic;
    private DeLuxMenu deLuxMenu;
    private Scanner scr;

    public CreateOrder() {
        this.indi = indi;
        this.classic = classic;
        this.deLuxMenu = deLuxMenu;
        this.scr = new Scanner(System.in);
    }

    public static AbstrOrderProcess getOrder(String type) {
        if (type.equalsIgnoreCase("Classic")) {
            return new ClassicMenu();
        } else if (type.equalsIgnoreCase("Delux")) {
            return new DeLuxMenu();
        } else if (type.equalsIgnoreCase("Indi")) {
            return new IndividualItems();
        } else
            throw new
                    IllegalStateException("Unexpected value: " + type.toUpperCase());

    }

    public IndividualItems getIndi() {
        return indi;
    }

    public ClassicMenu getClassic() {
        return classic;
    }

    public DeLuxMenu getDeLuxMenu() {
        return deLuxMenu;
    }
}
