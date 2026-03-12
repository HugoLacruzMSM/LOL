package hugo.lol.jsonCourse.nested;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;

public class ConfigLoader {
    public static AppConfig loadConfig(String filePath){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(filePath)){
            return gson.fromJson(reader, AppConfig.class);

        }catch (IOException ex){
            System.out.println("Error loading config file"+ ex.getMessage());
        }
        return null;
    }
    public static void main(String[] args) {

      AppConfig config =  loadConfig("src/main/java/hugo/lol/jsonCourse/nested/config.json");
            if (config != null){
                System.out.println("App name: " + config.getAppName());
                System.out.println("Settings: " + config.getSettings().getTheme());
                System.out.println("Settings: " + config.getSettings().isNotifications());
                System.out.println("Settings: " + config.getSettings().getLanguage());
                System.out.println("Version: " + config.getVersion());
            }
    }
}
