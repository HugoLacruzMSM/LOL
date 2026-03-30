package hugo.lol.entity.assasin;

import hugo.lol.entity.Champion;
import hugo.lol.entity.interfaces.CanAttack;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Assassin extends Champion implements CanAttack {
    int critical;

    public Assassin(String name, int health, int damage) {
        super(name, health, damage);
        this.critical = 20;
    }

    @Override
    public void specialAbility(Champion champion) {
        int critDamage = (getDamage() + critical) * 2;
        System.out.println(getName() + " executes CRITICAL STRIKE on " + champion.getName());
        champion.receiveDamage(critDamage);
    }

    @Override
    public void attack(Champion objective) {
        System.out.println("The champion"+ getName() +" is attacking to "+ objective.getName());
        objective.receiveDamage(getDamage());
    }
}
