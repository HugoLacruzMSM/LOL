package hugo.lol.entity.interfaces;
import hugo.lol.entity.Champion;

public interface Equippable {
    void applyEffect(Champion champion);
    void removeEffect(Champion champion);
}