package hugo.lol.jsonCourse.files;

import com.google.gson.Gson;
import hugo.lol.entity.mage.Mage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public static void main(String[] args)  {
        Mage mage = new Mage("Hugo",100,156,100);

        Gson gson = new Gson();

        try (FileWriter fileWriter = new FileWriter("src/main/java/hugo/lol/jsonCourse/files/mage.json")) {
            gson.toJson(mage,fileWriter);
            System.out.println("Saved mage");
        }catch (IOException e) {
            System.out.println("Error saving mage: "+ e.getMessage());
        }

        try (FileReader fileReader = new FileReader("src/main/java/hugo/lol/jsonCourse/files/mage.json")) {
            Mage mageJson = gson.fromJson(fileReader,Mage.class);
            System.out.println("Mage from json: " + mageJson);
        }catch (IOException e) {
            System.out.println("Error reading mage: "+ e.getMessage());
        }
        System.out.println("Done");
    }
}
