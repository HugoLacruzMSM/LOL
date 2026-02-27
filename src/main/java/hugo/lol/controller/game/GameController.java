package hugo.lol.controller.game;

import hugo.lol.entity.Champion;
import hugo.lol.entity.interfaces.CanHeal;
import hugo.lol.service.ChampionService;
import hugo.lol.service.UserInteractionService;

import java.util.List;

public class GameController {

    //TODO Cambiar esto en la siguiente hora con manejo de excepciones
    private final ChampionService championService;
    private final UserInteractionService userInteractionService;

    public GameController() {
        this.championService = new ChampionService();
        this.userInteractionService = new UserInteractionService();
    }

    public void start() {
        userInteractionService.showWelcome();

        boolean running = true;
        while (running) {
            int option = userInteractionService.showMainMenu();

            switch (option) {
                case 1 -> createChampion();
                case 2 -> listChampions();
                case 3 -> showStats();
                case 4 -> simulateCombat();
                case 5 -> levelUp();
                case 6 -> heal();
                case 0 -> running = false;
                default -> userInteractionService.showError("Invalid option");
            }
        }

        userInteractionService.close();
    }

    private void createChampion() {
        int type = userInteractionService.showChampionTypeMenu();
        String name = userInteractionService.askName();

        if (name.isEmpty()) {
            userInteractionService.showError("Name cannot be empty");
            return;
        }

        Champion champion = championService.createChampion(type, name);
        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (champion != null) {
            userInteractionService.showMessage("Created: " + champion.getName() + " (" + championService.size() + " total)");
        } else {
            userInteractionService.showError("Invalid type");
        }
    }

    private void listChampions() {
        userInteractionService.listChampions(championService.getAllChampions());
    }

    private void showStats() {
        if (championService.isEmpty()) {
            userInteractionService.showError("No champions available");
            return;
        }

        userInteractionService.listChampions(championService.getAllChampions());
        int index = userInteractionService.selectChampion("Select champion");

        Champion champion = championService.getChampion(index);
        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (champion != null) {
            userInteractionService.showStats(champion);
        } else {
            userInteractionService.showError("Invalid selection");
        }
    }

    private void simulateCombat() {
        if (championService.size() < 2) {
            userInteractionService.showError("Need at least 2 champions");
            return;
        }

        userInteractionService.listChampions(championService.getAllChampions());
        int idx1 = userInteractionService.selectChampion("Select attacker");
        int idx2 = userInteractionService.selectChampion("Select defender");

        Champion attacker = championService.getChampion(idx1);
        Champion defender = championService.getChampion(idx2);

        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (attacker == null || defender == null || idx1 == idx2) {
            userInteractionService.showError("Invalid selection");
            return;
        }

        userInteractionService.showCombatHeader(attacker, defender);
        userInteractionService.showRound(1, "Basic Attack");
        championService.combat(attacker, defender);

        userInteractionService.showMessage("\n" + championService.getCombatResult(attacker, defender));
    }

    private void levelUp() {
        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (championService.isEmpty()) {
            userInteractionService.showError("No champions available");
            return;
        }

        userInteractionService.listChampions(championService.getAllChampions());
        int index = userInteractionService.selectChampion("Select champion to level up");

        Champion champion = championService.getChampion(index);
        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (champion != null) {
            champion.levelUp();
        } else {
            userInteractionService.showError("Invalid selection");
        }
    }

    private void heal() {
        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (championService.isEmpty()) {
            userInteractionService.showError("No champions available");
            return;
        }

        List<Champion> healers = championService.getHealers();
        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (healers.isEmpty()) {
            userInteractionService.showError("No healers available");
            return;
        }

        userInteractionService.listChampions(healers);
        int healerIdx = userInteractionService.selectChampion("Select healer");

        Champion healerChampion = healers.get(healerIdx);
        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (!(healerChampion instanceof CanHeal healer)) {
            userInteractionService.showError("Invalid healer");
            return;
        }

        userInteractionService.listChampions(championService.getAllChampions());
        int targetIdx = userInteractionService.selectChampion("Select target");

        Champion target = championService.getChampion(targetIdx);
        //TODO Hacer manejo de excepción y enseñar el mensaje ahí
        if (target != null) {
            healer.heal(target);
        } else {
            userInteractionService.showError("Invalid target");
        }
    }
}
