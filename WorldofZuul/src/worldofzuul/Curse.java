package worldofzuul;

public class Curse {

    private String name;
    private String description;
    private String badStuff;
    private String imagePath;

    public Curse(String name, String description, String badStuff, String imagePath) {
        this.name = name;
        this.description = description;
        this.badStuff = badStuff;
        this.imagePath = imagePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBadStuff(String badStuff) {
        this.badStuff = badStuff;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBadStuff() {
        return badStuff;
    }

    public String getImagePath() {
        return imagePath;
    }
}
