import model.entity.Champion;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        Champion lux = new Champion("lux",1.50,true,"Mage","Photoooooo",20);


        System.out.println(lux);
        System.out.println(lux.getName());
        System.out.println(lux.getDescription());

        Champion garen = new Champion();
        garen.setName("Garen");
        garen.setSize(1.90);
        garen.setCategory("tank");
        garen.setDescription("DEMACIAAAAA");
        garen.setAge(40);

        garen.greet();
        String garenCategory = garen.getCategory();
        System.out.println("Category: "+ garenCategory);

        //Wrapper
        garen.setSize(Double.parseDouble("1.91"));
        System.out.println("Compare "+ garen.getSize() +" and "+lux.getSize() +": "+ Double.compare(garen.getSize(), lux.getSize()));

        //String
        System.out.println(garen.toString() + "\n" + lux.toString());
        //Static
        int result = Utils.add(lux.getAge(),garen.getAge());
        System.out.println("Total age champs "+result);


    }
}
