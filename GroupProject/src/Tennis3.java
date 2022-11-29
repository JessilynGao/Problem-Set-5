import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis3 extends JFrame implements Runnable, KeyListener {
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    HumanPaddle1 p2;
    Ball b1;
    SquareBall b2;
    boolean gameStarted;

    public Tennis3() {
        this.setSize(WIDTH, HEIGHT);
        gameStarted = false;

        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new HumanPaddle1(2);
        b2 = new SquareBall();

        this.setTitle("Pong Game");
        thread = new Thread(this);
        thread.start();
        this.setVisible(true);
        this.addKeyListener(this);
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if (b1.getX() < -10 || b1.getX() > 710) {
            g.setColor(Color.red);
            g.drawString("Game Over", 350, 250);
        } else {
            p1.draw(g);
            b1.draw(g);
            p2.draw(g);
            b2.draw(g);
        }
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

        }
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            p2.setUpAccel(true);

        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            p2.setDownAccel(true);

        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p2.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p2.setDownAccel(false);
        }

    }


    public void keyTyped(KeyEvent arg0) {

    }


}