package hugo.lol.entity.service;
import hugo.lol.entity.Champion;
import hugo.lol.entity.assasin.Assassin;
import hugo.lol.entity.healer.Healer;
import hugo.lol.entity.mage.Mage;
import hugo.lol.entity.tank.Tank;
import hugo.lol.exception.InvalidSelectionException;
import hugo.lol.service.ChampionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChampionServiceTest {

    private ChampionService service;

    @BeforeEach
    void setUp() {
        service = new ChampionService();
    }
    
    @Test
    void createChampionReturnsMage() throws InvalidSelectionException {
        Champion champion = service.createChampion(1, "Lux");
        assertInstanceOf(Mage.class, champion);
        assertEquals("Lux", champion.getName());
    }

    @Test
    void createChampionReturnsAssassin() throws InvalidSelectionException {
        Champion champion = service.createChampion(2, "Zed");
        assertInstanceOf(Assassin.class, champion);
        assertEquals("Zed", champion.getName());
    }

    @Test
    void createChampionReturnsTank() throws InvalidSelectionException {
        Champion champion = service.createChampion(3, "Malphite");
        assertInstanceOf(Tank.class, champion);
        assertEquals("Malphite", champion.getName());
    }

    @Test
    void createChampionReturnsHealer() throws InvalidSelectionException {
        Champion champion = service.createChampion(4, "Soraka");
        assertInstanceOf(Healer.class, champion);
        assertEquals("Soraka", champion.getName());
    }

    @Test
    void createChampionThrowsInvalidSelectionExceptionWhenOptionIsGreaterThanOptions() {
        assertThrows(InvalidSelectionException.class, () -> service.createChampion(99, "Unknown"));
    }

    @Test
    void createChampionThrowsInvalidSelectionExceptionWhenIs0() {
        assertThrows(InvalidSelectionException.class, () -> service.createChampion(0, "Unknown"));
    }

    @Test
    void getAllChampionsReturnsEmptyList() {
        assertTrue(service.getAllChampions().isEmpty());
    }

    @Test
    void getChampionThrowsIndexOutOfBoundsExceptionWhenChampionIsEmpty() {
        assertThrows(IndexOutOfBoundsException.class, () -> service.getChampion(0));
    }


    @Test
    void getHealersReturnsEmptyListWhenChampionDoesNotHaveHealers() {
        assertTrue(service.getHealers().isEmpty());
    }


    @Test
    void combatAttackerKillsDefenderWhenDefenderHealthIsZeroOrLess() throws InvalidSelectionException {
        Champion attacker = service.createChampion(2, "Zed");
        Champion defender = service.createChampion(1, "Lux");

        while (attacker.getHealth() > 0 && defender.getHealth() > 0) {
            service.combat(attacker, defender);
        }

        assertTrue(defender.getHealth() <= 0);
    }

    @Test
    void combatDefenderTakesDamage() throws InvalidSelectionException {
        Champion attacker = service.createChampion(2, "Zed");
        Champion defender = service.createChampion(3, "Malphite");
        int initialHealth = defender.getHealth();

        service.combat(attacker, defender);

        assertTrue(defender.getHealth() < initialHealth);
    }

    @Test
    void getCombatReturnsDrawWhenBothAreDead() throws InvalidSelectionException {
        Champion attacker = service.createChampion(1, "Lux");
        Champion defender = service.createChampion(1, "Xerath");

        while (attacker.getHealth() > 0) attacker.receiveDamage(attacker.getHealth());
        while (defender.getHealth() > 0) defender.receiveDamage(defender.getHealth());

        String result = service.getCombatResult(attacker, defender);
        assertEquals("Draw! Both champions fell.", result);
    }

    @Test
    void getCombatResultDefenderWinsWhenAttackerDead() throws InvalidSelectionException {
        Champion attacker = service.createChampion(1, "Lux");
        Champion defender = service.createChampion(3, "Malphite");

        while (attacker.getHealth() > 0) attacker.receiveDamage(attacker.getHealth());

        String result = service.getCombatResult(attacker, defender);
        assertEquals("Malphite wins!", result);
    }

    @Test
    void getCombatResultAttackerWinsWhenDefenderDead() throws InvalidSelectionException {
        Champion attacker = service.createChampion(2, "Zed");
        Champion defender = service.createChampion(1, "Lux");

        while (defender.getHealth() > 0) defender.receiveDamage(defender.getHealth());

        String result = service.getCombatResult(attacker, defender);
        assertEquals("Zed wins!", result);
    }

    @Test
    void getCombatResultReturnsBothSurvivedMessageWhenBothAlive() throws InvalidSelectionException {
        Champion attacker = service.createChampion(3, "Malphite");
        Champion defender = service.createChampion(3, "Mundo");

        String result = service.getCombatResult(attacker, defender);
        assertTrue(result.contains("Both survived!"));
        assertTrue(result.contains("Malphite"));
        assertTrue(result.contains("Mundo"));
    }

    @Test
    void isEmptyReturnsTrueWhenNewService() {
        assertTrue(service.isEmpty());
    }

    @Test
    void sizeReturnsZeroWhenNewService() {
        assertEquals(0, service.size());
    }
}
