import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends JFrame implements Runnable, KeyListener {
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;
    boolean gameStarted;
    Graphics g;

    public Tennis(){
        this.setSize(WIDTH, HEIGHT);
        gameStarted = false;
        this.setTitle("Pong Game");
        this.setVisible(true);
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new AIPaddle(2, b1);
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        if(b1.getX() < -10 || b1.getX() > 710){
            g.setColor(Color.red);
            g.drawString("Game Over",350,250);
        }
        else {
            p1.draw(g);
            b1.draw(g);
            p2.draw(g);
        }
        if(!gameStarted){
            g.setColor(Color.white);
            g.drawString("Tennis", 340, 100);
            g.drawString("Press Enter to Begin..", 310, 130);
        }
    }

    public void update(Graphics g){
        paint(g);
    }
    public void run(){
        for(;;){
            if (gameStarted) {
                p1.move();
                p2.move();
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
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAccel(true);
        } else if (e.getKeyCode () == KeyEvent.VK_DOWN){
            p1.setDownAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
        }
    }
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAccel(false);
        } else if (e.getKeyCode () == KeyEvent.VK_DOWN){
            p1.setDownAccel(false);
        }
    }
    public void keyTyped(KeyEvent arg0) {

    }
}
