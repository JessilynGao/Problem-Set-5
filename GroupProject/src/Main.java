import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Choose the game level: easy or difficult");
        String gameLevel = scnr.nextLine();
        System.out.println("Choose game type: 1 player or 2 players");
        int gametype = scnr.nextInt();

        if (gameLevel.equals("easy") && gametype == 1){
            Tennis game = new Tennis();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        else if (gameLevel.equals("difficult") && gametype == 1){
            Tennis1 game1 = new Tennis1();
            game1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        else if (gameLevel.equals("easy")&& gametype == 2){
            Tennis2 game2 = new Tennis2();
            game2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if (gameLevel.equals("difficult")&& gametype == 2){
            Tennis3 game3 = new Tennis3();
            game3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


        }





    }

