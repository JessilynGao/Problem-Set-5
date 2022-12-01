/**********************************************************************
 * @file Tennis1.java
 * @brief The Tennis1 class defines the main process of the game,
 *        defines key events, and creates the visual for difficult game
 *        (2 balls) and 1 player.
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis1 extends JFrame implements Runnable, KeyListener {

    //set the size of the canvas and create variables and objects
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;
    SquareBall b2;
    boolean gameStarted;
    public Text leftScoreText, rightScoreText;

    //create constructor to set up the background, font, and the title of the game
    //the constructor also contains "this reference" and defined objects
    public Tennis1() {
        leftScoreText = new Text(0, new Font("Times New Roman", Font.PLAIN, 20), 10, 60);
        rightScoreText = new Text(0, new Font("Times New Roman", Font.PLAIN,20), 650, 60);

        this.setSize(WIDTH, HEIGHT);
        gameStarted = false;

        p1 = new HumanPaddle(1);
        b1 = new Ball();
        b2 = new SquareBall();
        p2 = new AIPaddle(2, b1);

        this.setTitle("Pong Game");
        thread = new Thread(this);
        thread.start();
        this.setVisible(true);
        this.addKeyListener(this);
    }

    public void paint(Graphics g) {
        //draw the background
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        leftScoreText.draw(g2);
        rightScoreText.draw(g2);

        //add one score to player 2 if the ball hits the wall of player 1 and vice versa
        if (b1.getX() < -10 || b1.getX() > 710) {
            if (b1.getX() < -10){
                if (p2.AIscore <= 10) {
                    p2.AIscore++;
                }
                rightScoreText.text = "" + p2.AIscore;
            }
            else if (b1.getX() > 710) {
                if (p1.score <= 10) {
                    p1.score++;
                }
                leftScoreText.text = "" + p1.score;
            }
            //reset the coordinates of the ball
            b1.x = 350;
            b1.y = 250 - 10;
            b2.x = 330;
            b2.y = 150 + 10;
        }

        // game continue
        else if (p2.AIscore <= 10 && p1.score <= 10) {
            p1.draw(g);
            b1.draw(g);
            p2.draw(g);
            b2.draw(g);
        }

        //game stops and print winner
        if (p2.AIscore >= 11) {
            g.setColor(Color.white);
            g.drawString("End", 340, 240);
            g.drawString("P2 WIN", 320, 300);
            return;
        }
        if (p1.score >= 11) {
            g.setColor(Color.white);
            g.drawString("End", 340, 240);
            g.drawString("P1 WIN", 320, 300);
            return;
        }

        // the text appears before the start of the game
        if (!gameStarted) {
            g.setColor(Color.white);
            g.drawString("Tennis", 320, 100);
            g.drawString("Press Enter to Begin", 290, 130);
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
                b2.move();
                b1.checkPaddleCollision(p1, p2);
                b2.checkPaddleCollision(p1, p2);
            }
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // keys that controls the movement of Humanpaddle
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);

        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
        }
    }

    // keys that controls the movement of Humanpaddles
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        }

    }

    public void keyTyped(KeyEvent arg0) {

    }


}