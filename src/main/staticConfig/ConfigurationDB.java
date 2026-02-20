package main.staticConfig;

public class ConfigurationDB {
   private static final String URL;
   private static final String USER;

    static {
        URL = "jdbc:mysql://localhost:3306/";
        USER = "root";
        System.out.println("Charged DB Conf");
    }

    public static void main(String[] args) {
        System.out.println(URL);
        System.out.println(USER);
    }
}
