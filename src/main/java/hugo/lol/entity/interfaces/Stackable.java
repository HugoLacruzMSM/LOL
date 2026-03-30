package hugo.lol.entity.interfaces;

public interface Stackable {
    int getQuantity();
    void addStack(int amount);
    void removeStack(int amount);
    boolean isEmpty();
}