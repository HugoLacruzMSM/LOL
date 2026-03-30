package hugo.lol.entity.item;

import hugo.lol.entity.interfaces.Storable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item implements Storable {
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

    @Override
    public String toString() {
        return name + " (" + width + "x" + height + ") - " + price + "g";
    }
}