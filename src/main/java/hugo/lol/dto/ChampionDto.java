package hugo.lol.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChampionDto {
    private String type;
    private String name;
    private int health;
    private int damage;
    private int mana;
    private int healPower;


}