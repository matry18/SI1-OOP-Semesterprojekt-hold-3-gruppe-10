package Bonuses;

public class Item implements Comparable<Item> {

    private String name;
    private int bonus;
    private String dataType; //Used for printing the type of item. Example: Headgear.
    private int dataNum; //Used for sorting the inventory. Headgear = 1, Armor = 2 and so on.
    private String imgPath;

    public Item(String name, int bonus, String dataType, int dataNum, String imgPath) {
        this.name = name;
        this.bonus = bonus;
        this.dataType = dataType;
        this.dataNum = dataNum;
        this.imgPath = imgPath;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getDataNum() {
        return dataNum;
    }

    public void setDataNum(int dataNum) {
        this.dataNum = dataNum;
    }

    @Override
    public int compareTo(Item o) { //Items are compared for inventory management purposes.
        return this.getDataNum() - o.getDataNum();
    }

    public String getImgPath() {
        return imgPath;
    }
}
