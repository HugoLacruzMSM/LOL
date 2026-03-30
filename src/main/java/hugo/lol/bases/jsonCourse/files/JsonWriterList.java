package hugo.lol.bases.jsonCourse.files;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hugo.lol.entity.mage.Mage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonWriterList {
    public static void main(String[] args)  {
        Gson gson = new Gson();

        List<Mage> allMages = new ArrayList<>();

        try (FileReader fileReader = new FileReader("src/main/java/hugo/lol/jsonCourse/files/mage.json")) {
            Type listType = new TypeToken<List<Mage>>(){}.getType();
            allMages = gson.fromJson(fileReader,listType);
            System.out.println("Mage from json: " + allMages);
        }catch (IOException e) {
            System.out.println("Error reading mage: "+ e.getMessage());
        }

        for (Mage mage : allMages) {
            System.out.println("\n----------------------");
            System.out.println("Mage: "+mage);
            System.out.println("----------------------\n");
        }

        allMages.add(new Mage("Pepe",100,150,100));

        try (FileWriter fileWriter = new FileWriter("src/main/java/hugo/lol/jsonCourse/files/mage.json")) {
            gson.toJson(allMages,fileWriter);
            System.out.println("Mage to json: " + allMages);
        }catch (IOException e) {
            System.out.println("Error writing mage: "+ e.getMessage());
        }

        try (FileReader fileReader = new FileReader("src/main/java/hugo/lol/jsonCourse/files/mage.json")) {
            Type listType = new TypeToken<List<Mage>>(){}.getType();
            allMages = gson.fromJson(fileReader,listType);
            System.out.println("Mage from json: " + allMages);
        }catch (IOException e) {
            System.out.println("Error reading mage: "+ e.getMessage());
        }

        for (Mage mage : allMages) {
            System.out.println("\n----------------------");
            System.out.println("Mage: "+mage);
            System.out.println("----------------------\n");
        }


        System.out.println("Done");
    }
}
