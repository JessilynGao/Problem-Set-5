import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Pong extends JFrame implements Runnable, KeyListener {
    int gWidth = 500;
    int gHeight = 400;
    Dimension screenSize = new Dimension(gWidth, gHeight);

    Image dbImage;
    Graphics dbGraphics;


    public Pong() {
        this.setTitle("Pong!");
        this.setSize(screenSize);
        this.setResizable(false);
        this.setVisible(true);
        this.setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new AL());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }
}