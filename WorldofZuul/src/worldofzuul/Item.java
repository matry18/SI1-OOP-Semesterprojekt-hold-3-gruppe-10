package worldofzuul;

public class Item implements Comparable<Item> {

    private String name;
    private int bonus;
    private String dataType;
    private int dataNum;

    public Item(String name, int bonus, String dataType, int dataNum) {
        this.name = name;
        this.bonus = bonus;
        this.dataType = dataType;
        this.dataNum = dataNum;
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
    public int compareTo(Item o) {
        return this.getDataNum() - o.getDataNum();
    }
}
