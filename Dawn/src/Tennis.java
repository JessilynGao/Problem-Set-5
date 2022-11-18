
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Tennis extends JFrame implements Runnable, KeyListener{
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;

    public void init(){
        this.resize(WIDTH, HEIGHT);
        gameStarted = false;
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        p2 = new AIPaddle(2, p1);
        b1 = new Ball();
        thread = new Thread(this);
        thread.start();
    }

    public void paint (Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        if (b1.getX() <-10 || b1.getX() >710) {
            g.setColor(Color.red);
            g.drawString("Game Over",350, 250);
        }
        else {
            p1.draw(g);
            b1.draw(g);
        }
        p1.draw(g);
        b1.draw(g);
        p2.draw(g);
    }

    public void update (Graphics g) {
        paint (g);
    }

    public void run(){
        for (;;) {
            if (gameStarted) {
                p1.move();
                b1.move();
                b1.checkPaddleCollision(p1, p1);
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void keyPressed (KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_UP) {
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted == true;
        }
    }

    public void keyReleased (KeyEvent e) {
        if (e.getKeyCode () == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }




}
