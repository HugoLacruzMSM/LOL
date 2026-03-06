package hugo.lol.service;

import hugo.lol.entity.Champion;
import hugo.lol.entity.assasin.Assassin;
import hugo.lol.entity.healer.Healer;
import hugo.lol.entity.mage.Mage;
import hugo.lol.entity.tank.Tank;
import hugo.lol.entity.interfaces.CanHeal;
import hugo.lol.exception.InvalidSelectionException;

import java.util.ArrayList;
import java.util.List;

public class ChampionService {

    private final List<Champion> champions;

    public ChampionService() {
        this.champions = new ArrayList<>();
    }

    public Champion createChampion(int type, String name) throws InvalidSelectionException {
            Champion champion = switch (type) {
                case 1 -> new Mage(name, 500, 60, 300);
                case 2 -> new Assassin(name, 600, 80);
                case 3 -> new Tank(name,  1000, 40);
                case 4 -> new Healer(name, 700, 300, 150);
                default -> null;
            };

            if (champion == null) {
                throw new InvalidSelectionException("The selected champion can not be null.");
            }
            champions.add(champion);
            return champion;
    }

    public List<Champion> getAllChampions() {
        return new ArrayList<>(champions);
    }

    public Champion getChampion(int index) throws IndexOutOfBoundsException {
            return champions.get(index);
    }

    public List<Champion> getHealers() {
        return champions.stream()
                .filter(champion -> champion instanceof CanHeal)
                .toList();
    }

    public void combat(Champion attacker, Champion defender) {
        defender.receiveDamage(attacker.getDamage());
        if (defender.getHealth() > 0) {
            attacker.receiveDamage(defender.getDamage());
        }

        if (defender.getHealth() > 0 && attacker.getHealth() > 0) {
            attacker.specialAbility(defender);
            if (defender.getHealth() > 0) {
                defender.specialAbility(attacker);
            }
        }
    }

    public String getCombatResult(Champion attacker, Champion defender) {
        if (attacker.getHealth() <= 0 && defender.getHealth() <= 0) {
            return "Draw! Both champions fell.";
        } else if (attacker.getHealth() <= 0) {
            return defender.getName() + " wins!";
        } else if (defender.getHealth() <= 0) {
            return attacker.getName() + " wins!";
        } else {
            return String.format("Both survived! %s: %d HP | %s: %d HP",
                    attacker.getName(), attacker.getHealth(),
                    defender.getName(), defender.getHealth());
        }
    }

    public int size() {
        return champions.size();
    }

    public boolean isEmpty() {
        return champions.isEmpty();
    }
}
