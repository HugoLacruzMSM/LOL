package hugo.lol.entity.item;

import hugo.lol.entity.Champion;

public abstract class Item {
    private final String name;
    private final int price;
    private final int width;
    private final int height;

    public Item(String name, int price, int width, int height) {
        this.name = name;
        this.price = price;
        this.width = width;
        this.height = height;
    }

    public abstract void applyEffect(Champion champion);

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
