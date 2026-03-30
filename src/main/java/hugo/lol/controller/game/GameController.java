package hugo.lol.controller.game;

import hugo.lol.entity.Champion;
import hugo.lol.entity.healer.Healer;
import hugo.lol.exception.InvalidSelectionException;
import hugo.lol.service.ChampionService;
import hugo.lol.service.ChampionConsoleService;
import loader.ChampionLoader;
import java.util.List;

public class GameController {

    private final ChampionService championService;
    private final ChampionConsoleService championConsoleService;

    public GameController() {
        this.championService = new ChampionService();
        this.championConsoleService = new ChampionConsoleService();
        loadChampions();
    }

    public void start() {
        try {
            championConsoleService.showWelcome();

            boolean running = true;
            while (running) {
                int option = championConsoleService.showMainMenu();

                switch (option) {
                    case 1 -> showAllChampions();
                    case 2 -> showStats();
                    case 3 -> simulateCombatMenu();
                    case 4 -> levelUpMenu();
                    case 5 -> healMenu();
                    case 0 -> running = false;
                    default -> throw new InvalidSelectionException("Invalid option");
                }
            }

            championConsoleService.close();
        } catch (InvalidSelectionException e) {
            start();
        }
    }

    private void loadChampions() {
        ChampionLoader loader = new ChampionLoader();
        List<Champion> champions = loader.load("champions.json");
        championService.loadAll(champions);
        championConsoleService.showMessage("Loaded " + champions.size() + " champions.");
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
}
