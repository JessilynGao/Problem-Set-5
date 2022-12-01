/**********************************************************************
 * @file Main.java
 * @brief The Main class collects response from the user regarding the
 *        game difficulty level and number of players
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 * @acknowledgement: CS center, Dr. Pauca, and the Youtube video "How to Program Pong in Java" by
 *                    Korhn-Education
 ***********************************************************************/

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create gameLevel and gametype variables which allows
        //users to choose their preferred game model
        Scanner scnr = new Scanner(System.in);
        System.out.println("Choose the game level: easy or difficult");
        String gameLevel = scnr.nextLine();
        System.out.println("Choose game type: 1 player or 2 players");
        int gametype = scnr.nextInt();

        //call Tennis and run the game
        if (gameLevel.equals("easy") && gametype == 1) {
            Tennis game = new Tennis();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        //call Tennis1 and run the game
        else if (gameLevel.equals("difficult") && gametype == 1) {
            Tennis1 game1 = new Tennis1();
            game1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        //call Tennis2 and run the game
        else if (gameLevel.equals("easy") && gametype == 2) {
            Tennis2 game2 = new Tennis2();
            game2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        //call Tennis3 and run the game
        else if (gameLevel.equals("difficult") && gametype == 2) {
            Tennis3 game3 = new Tennis3();
            game3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


    }
}







