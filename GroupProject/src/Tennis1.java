/**********************************************************************
 * @file Tennis1.java
 * @brief The Tennis1 class defines the main process of the game,
 * defines key events, and creates the visual for difficult game
 * (2 balls) and 1 player.
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis1 extends JFrame implements Runnable, KeyListener {
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;
    SquareBall b2;
    boolean gameStarted;
   Text leftInstruction;

    public Tennis1() {
        leftInstruction = new Text("Up/Down", new Font("Times New Roman", Font.PLAIN, 25), 10, 60);

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
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        leftInstruction.draw(g2);
        if (b1.getX() < -10 || b1.getX() > 710 || b2.getX() < -10 || b2.getX() > 710) {
            g.setColor(Color.red);
            g.drawString("Game Over", 250, 250);
        } else {
            p1.draw(g);
            b1.draw(g);
            b2.draw(g);
            p2.draw(g);
        }
        if (!gameStarted) {
            g.setColor(Color.white);
            g.drawString("Tennis", 280, 100);
            g.drawString("Press Enter to Begin", 200, 130);

        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void repaint(Graphics g){
        repaint(g);
    }


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

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);

        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
        }
    }

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
