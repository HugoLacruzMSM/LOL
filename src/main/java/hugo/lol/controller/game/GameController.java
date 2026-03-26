package hugo.lol.controller.game;

import hugo.lol.entity.Champion;
import hugo.lol.entity.healer.Healer;
import hugo.lol.entity.inventory.ConsumableBag;
import hugo.lol.entity.item.Item;
import hugo.lol.entity.item.consumable.ConsumableItem;
import hugo.lol.entity.item.equipment.EquipmentItem;
import hugo.lol.entity.shop.Shop;
import hugo.lol.exception.InvalidSelectionException;
import hugo.lol.service.ChampionService;
import hugo.lol.service.ChampionConsoleService;

import javax.naming.InvalidNameException;
import java.util.List;

public class GameController {

    private final ChampionService championService;
    private final ChampionConsoleService championConsoleService;
    private final Shop shop;

    public GameController() {
        this.championService = new ChampionService();
        this.championConsoleService = new ChampionConsoleService();
        this.shop = new Shop("Item Shop");
        loadShopItems();
    }

    public void start() {
        try {
            championConsoleService.showWelcome();

            boolean running = true;
            while (running) {
                int option = championConsoleService.showMainMenu();

                switch (option) {
                    case 1 -> createChampionMenu();
                    case 2 -> showAllChampions();
                    case 3 -> showStats();
                    case 4 -> simulateCombatMenu();
                    case 5 -> levelUpMenu();
                    case 6 -> healMenu();
                    case 7 -> inventoryMenu();
                    case 8 -> shopMenu();
                    case 0 -> running = false;
                    default -> throw new InvalidSelectionException("Invalid option");
                }
            }

            championConsoleService.close();
        } catch (InvalidSelectionException e) {
            start();
        }
    }

    private void createChampionMenu() {
        int type = askChampionType();
        String name = askName();
        Champion champion = createChampion(type,name);
        championConsoleService.showMessage("Created: " + champion.getName() + " (" + championService.size() + " total)");
    }

    private void simulateCombatMenu() {
        if (championService.size() < 2) {
            championConsoleService.showMessage("Need at least 2 champions");
            return;
        }

        showAllChampions();
        try {
            Champion attacker = selectAttacker();
            Champion defender = selectDefender();

            if (attacker == defender) {
                throw new InvalidSelectionException("Attacker and defender can not be the same");
            }

            simulateCombat(attacker, defender);
        } catch (IndexOutOfBoundsException | InvalidSelectionException e) {
            simulateCombatMenu();
        }
    }

    private void levelUpMenu() {
        if (championService.isEmpty()) {
            championConsoleService.showMessage("No champions found");
            return;
        }

        showAllChampions();

        int index = championConsoleService.selectChampion("Select champion to level up");
        try {
            levelUp(index);
        }catch (IndexOutOfBoundsException e) {
            levelUpMenu();
        }
    }

    private void healMenu() {

        if (championService.isEmpty() || championService.getHealers().isEmpty()) {
            championConsoleService.showMessage("No healers available");
            return;
        }

        try {

        Healer healerChampion = selectHealer();

        showAllChampions();

        Champion targetChampion = selectChampion();

        heal(healerChampion,targetChampion);
        }catch (IndexOutOfBoundsException e) {
            healMenu();
        }
    }

    private void inventoryMenu() {
        if (championService.isEmpty()) {
            championConsoleService.showMessage("No champions.");
            return;
        }

        Champion champion = selectChampion();
        championConsoleService.showInventory(champion);

        int option = championConsoleService.showInventoryMenu();

        switch (option) {
            case 1 -> useConsumableMenu(champion);
            //case 2 -> //aqui equipo la armadura al campeon;
            case 0 -> {}
            default -> championConsoleService.showMessage("Invalid option.");
        }
    }

    private void useConsumableMenu(Champion champion) {
        ConsumableBag bag = champion.getInventory().getConsumableBag();

        if (bag.isEmpty()) {
            championConsoleService.showMessage("No consumables.");
            return;
        }

        bag.print();
        int index = championConsoleService.selectItem("Select consumable");

        //usar consumible
    }

    private void shopMenu() {
        if (championService.isEmpty()) {
            championConsoleService.showMessage("No champions.");
            return;
        }
        championConsoleService.showShop(shop);
        Champion champion = selectChampion();

        List<Item> stock = shop.getStock();
        for (int i = 0; i < stock.size(); i++) {
            System.out.println((i + 1) + ". " + stock.get(i));
        }
        int itemIndex = championConsoleService.selectItem("Select item to buy");
        if (itemIndex < 0 || itemIndex >= stock.size()){
            return;
        }

        championService.buyItem(
                championService.getAllChampions().indexOf(champion),
                stock.get(itemIndex),
                shop
        );
    }

    private int askChampionType() {
        try {
            return championConsoleService.askChampionType();
        } catch (Exception e) {
            return askChampionType();
        }
    }

    private String askName() {
        try {
            return championConsoleService.askName();
        } catch (InvalidNameException e) {
            return askName();
        }
    }

    private void showStats() throws InvalidSelectionException {
        if (championService.isEmpty()) {
            championConsoleService.showMessage("No champions found");
            return;
        }
        try {
            championConsoleService.showStats(selectChampion());
        } catch (IndexOutOfBoundsException e) {
            championConsoleService.showStats(selectChampion());
        }
    }

    private void showAllChampions(){
        championConsoleService.listChampions(championService.getAllChampions());
    }

    private void simulateCombat(Champion attacker, Champion defender) {
        championConsoleService.showCombatHeader(attacker, defender);
        championConsoleService.showRound(1, "Basic Attack");
        championService.combat(attacker, defender);

        championConsoleService.showMessage("\n" + championService.getCombatResult(attacker, defender));
    }

    private Champion createChampion(int type, String name) {
        try {
            //log.debug("Created champ");
            return championService.createChampion(type, name);
        } catch (InvalidSelectionException e) {
            //log.warn(e.getMessage)
            return createChampion(type,name);
        }
    }

    private void levelUp(int championIndex) throws IndexOutOfBoundsException{
        Champion champion = championService.getChampion(championIndex);
        champion.levelUp();
    }

    private void heal(Healer healer, Champion target) throws IndexOutOfBoundsException{
        healer.heal(target);
    }

    private Champion selectChampion() throws IndexOutOfBoundsException {
        showAllChampions();
        int index = championConsoleService.selectChampion("Select champion");
        return championService.getChampion(index);
    }

    private Champion selectAttacker() throws IndexOutOfBoundsException {
        int attacker = championConsoleService.selectChampion("Select attacker");
        return championService.getChampion(attacker);
    }

    private Champion selectDefender() throws IndexOutOfBoundsException {
        int defender = championConsoleService.selectChampion("Select defender");
        return championService.getChampion(defender);
    }

    private Healer selectHealer()throws IndexOutOfBoundsException{
        List<Champion> healers = championService.getHealers();
        championConsoleService.listChampions(healers);

        int healerIdx = championConsoleService.selectChampion("Select healer");
        return (Healer) healers.get(healerIdx);
    }

    private void loadShopItems() {
        shop.addStock(new EquipmentItem("Iron Helmet", 100, 1, 1, 50, 0));
        shop.addStock(new EquipmentItem("Chainmail", 200, 2, 2, 100, 10));
        shop.addStock(new ConsumableItem("Health Potion", 50, 150));
        shop.addStock(new ConsumableItem("Mega Potion", 100, 300));
    }
}
