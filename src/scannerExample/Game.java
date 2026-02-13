package scannerExample;

import model.entity.Champion;
import model.entity.Player;

import java.util.Scanner;

public class Game {
    Player player;

    public void start(){
        player = playerWelcome();
        if (playGame(player)){

        }else {
            System.out.println("Exit");
            System.exit(0);
        }

    }

    public Player playerWelcome(){
        Player player = new Player();
        System.out.println("Welcome to the game!");
        System.out.println("Introduce your username");
        Scanner in = new Scanner(System.in);
        player.setUsername(in.nextLine());
        player.setLevel(1);
        player.setRank("Unranked");
        System.out.println("Welcome " + player.getUsername() + " your level is " + player.getLevel() + " and your rank is " + player.getRank() +".");
        return player;
    }

    public boolean playGame(Player player){
        Scanner in = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println(player.toString());
        System.out.println("--------------------------------");
        System.out.println("Do you want to play?");
        System.out.println("1. Play Game");
        System.out.println("2. Quit Game");
        System.out.println("--------------------------------");
        int choice = in.nextInt();
        return choice == 1;
    }

}
