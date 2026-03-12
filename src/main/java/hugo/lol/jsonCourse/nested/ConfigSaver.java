package hugo.lol.jsonCourse.nested;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigSaver {

    public static void saveConfig(AppConfig config,String filePath){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(config, writer);
            System.out.println("Config saved at: " + filePath);

        }catch (IOException ex){
            System.out.println("Error loading config file"+ ex.getMessage());
        }
    }
    public static void main(String[] args) {
        String configFilePath = "src/main/java/hugo/lol/jsonCourse/nested/config.json";
        AppConfig config = ConfigLoader.loadConfig(configFilePath);
        if (config != null){
            config.getSettings().setTheme("red");
            saveConfig(config,configFilePath);
        }
    }
}
