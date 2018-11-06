package worldofzuul;

public class Item {

    private String name;
    private int bonus;
    private String dataType;

    private String oneHand = "oneHand";
    private String twoHand = "twoHand";
    private String armor = "armor";
    private String headgear = "headgear";
    private String footgear = "footgear";
    private String usableOnceOnly = "usableOnceOnly";
    private String negativeModifier = "negativeModifier";

    public Item(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
