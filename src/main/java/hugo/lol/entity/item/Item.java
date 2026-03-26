package hugo.lol.entity.item;

import hugo.lol.entity.Champion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Item {
    private final String name;
    private final int price;
    private final int width;
    private final int height;

    protected Item(String name, int price, int width, int height) {
        this.name = name;
        this.price = price;
        this.width = width;
        this.height = height;
    }

    public abstract void applyEffect(Champion champion);

    public List<Position> getOccupiedCells(int startRow, int startCol) {
        List<Position> positions = new ArrayList<>();
        for (int row = startRow; row < startRow + height; row++) {
            for (int column = startCol; column < startCol + width; column++) {
                positions.add(new Position(row, column));
            }
        }
        return positions;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public String toString() { return name + " (" + price + "g)"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return price == item.price && width == item.width
                && height == item.height && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name, price, width, height); }
}
