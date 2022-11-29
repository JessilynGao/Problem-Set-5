import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Choose the game level: easy or difficult");
        String gameLevel = scnr.nextLine();
        if (gameLevel.equals("easy")){
            Tennis game = new Tennis();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else{
            Tennis1 game1 = new Tennis1();
            game1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        }




    }

