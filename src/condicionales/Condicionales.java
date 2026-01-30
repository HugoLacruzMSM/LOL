package condicionales;

public class Condicionales {
    public static void main(String[] args) {
        int honor = (int) (Math.random() * 5) + 1;
        double average = (Math.random() * 6) + 2;
        System.out.println("honor: "+honor);
        if (honor <= 3 && average <= 7){
            System.out.println("Honor less than: 18 bad played");
        }else if(honor >= 4 && average >= 7) {
            System.out.println("Honor: less than 18 well played");
        }else {
            System.out.println("Honor: "+ honor + "Average: "+ average);
        }

        int friends= (int) (Math.random() * 10) + 1;
        System.out.println("friends: "+friends);

        switch (friends){
            case 1:
                System.out.println("Friend 1");
                break;
            case 2:
                System.out.println("Friend 2");
                break;
            case 3:
                System.out.println("Friend 3");
                break;

            default:
                System.out.println("Friendly");
                break;
        }
    }
}
