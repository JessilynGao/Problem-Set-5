/**********************************************************************
 * @file Tennis.java
 * @brief It consists of two paddled controlled by the user and the computer. In this program,
 *        the ball bounces off the four walls and the user tries to keep the ball from hitting
 *        the side wall. When the ball hits the side wall, the game is over.
 * @author Jessilyn Gao
 * @date: 11/20/2022
 * @acknowledgement: CS center, Dr. Pauca, and the Youtube video "How to Program Pong in Java" by
 *                   Korhn-Education
 ***********************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends JFrame implements Runnable, KeyListener {

    //set the size of the canvas and create variables and objects
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;
    boolean gameStarted;


    //create constructor to set up the background, font, and the title of the game
    //the constructor also contains "this reference" and defined objects
    public Tennis() {
        this.setSize(WIDTH, HEIGHT);
        gameStarted = false;

        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new AIPaddle(2, b1);

        this.setTitle("Pong Game");
        thread = new Thread(this);
        thread.start();
        this.setVisible(true);
        this.addKeyListener(this);
    }

    public void paint(Graphics g) {
        //draw the background
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //if the ball hits the wall, game over
        //set text info for "Game over" on the screen
        if (b1.getX() < -10 || b1.getX() > 710) {
            g.setColor(Color.red);
            g.drawString("Game Over", 350, 250);
        }
        // game continue
        else {
            p1.draw(g);
            b1.draw(g);
            p2.draw(g);
        }
        // the text appears before the start of the game
        if (!gameStarted) {
            g.setColor(Color.white);
            g.drawString("Tennis", 340, 100);
            g.drawString("Press Enter to Begin", 310, 130);
        }
    }


    public void update(Graphics g) {
        paint(g);
    }

    public void repaint(Graphics g){
        repaint(g);
    }

    //run method inherits from the Runnable interface
    //controls the movement of paddles and balls and check the collision between ball and paddles
    public void run() {

        for (; ; ) {
            if (gameStarted) {

                p1.move();
                b1.move();
                p2.move();
                b1.checkPaddleCollision(p1, p2);
            }
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // keys that control the movement of Humanpaddle
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);

        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
        }
    }

    // keys that control the movement of Humanpaddle
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        }

    }

    public void keyTyped(KeyEvent arg0) {

    }

    //game starts
    public static void main(String[] args) {
        Tennis game = new Tennis();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}