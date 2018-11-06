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

    public Item(String name, int bonus/*, int itemType*/) {
        this.name = name;
        this.bonus = bonus;
       /* switch (itemType) {
            case 1:
                this.dataType = oneHand;
                break;
            case 2:
                this.dataType = twoHand;
                break;
            case 3:
                this.dataType = armor;
                break;
            case 4:
                this.dataType = headgear;
                break;
            case 5:
                this.dataType = footgear;
                break;
            case 6:
                this.dataType = usableOnceOnly;
                break;
            case 7:
                this.dataType = negativeModifier;
                break;
        } */
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
/*
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
    public void test(Item item){
        if(getDataType().equals(item.getDataType())){
            System.out.println("Alt er godt");
        }
    }
*/

}
