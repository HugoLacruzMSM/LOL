package hugo.lol.jsonCourse;

import com.google.gson.Gson;
import hugo.lol.entity.Champion;
import hugo.lol.entity.mage.Mage;

public class MainClass {

    public static void main(String[] args) {
        //Serialize
        Mage mage = new Mage("Hugo",100,156,100);
        Gson gson = new Gson();
        String json = gson.toJson(mage);
        System.out.println("Serialized: "+json);
        //Deserialize
        Mage mage2 = gson.fromJson(json, Mage.class);
        System.out.println("Deserialized: " + mage2);
    }
}
