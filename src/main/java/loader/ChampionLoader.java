package loader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hugo.lol.dto.ChampionDto;
import hugo.lol.entity.Champion;
import hugo.lol.entity.assasin.Assassin;
import hugo.lol.entity.healer.Healer;
import hugo.lol.entity.mage.Mage;
import hugo.lol.entity.tank.Tank;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ChampionLoader {

    private final Gson gson = new Gson();

    public List<Champion> load(String resourcePath) {
        InputStream file = getClass().getClassLoader().getResourceAsStream(resourcePath);

        if (file == null) {
            throw new IllegalStateException("Resource not found: " + resourcePath);
        }

        Type listType = new TypeToken<List<ChampionDto>>(){}.getType();
        List<ChampionDto> champions = gson.fromJson(new InputStreamReader(file), listType);

        List<Champion> result = new ArrayList<>();
        for (ChampionDto dto : champions) {
            result.add(toChampion(dto));
        }
        return result;
    }

    private Champion toChampion(ChampionDto dto) {
        return switch (dto.getType().toUpperCase()) {
            case "MAGE"     -> new Mage(dto.getName(), dto.getHealth(), dto.getDamage(), dto.getMana());
            case "ASSASSIN" -> new Assassin(dto.getName(), dto.getHealth(), dto.getDamage());
            case "TANK"     -> new Tank(dto.getName(), dto.getHealth(), dto.getDamage());
            case "HEALER"   -> new Healer(dto.getName(), dto.getHealth(), dto.getMana(), dto.getHealPower());
            default -> throw new IllegalArgumentException("Unknown type: " + dto.getType());
        };
    }
}