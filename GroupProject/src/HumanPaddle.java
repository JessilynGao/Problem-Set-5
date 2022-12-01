/**********************************************************************
 * @file HumanPaddle.java
 * @brief The HumanPaddle class defines the movement of one human paddle
 *        that responds to the key events
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/
import java.awt.*;

public class HumanPaddle implements Paddle {

    // create variables
    double y, yVel;
    boolean upAccel, downAccel;
    final double GRAVITY = 0.94;
    int player, x;
    int score = 0;

    // create a constructor that receive int player variable
    public HumanPaddle(int player) {
        upAccel = false;
        downAccel = false;

        // set the location of the paddle and the speed equals 0
        y = 210;
        yVel = 0;
        if (player == 1) {
            x = 20;
        } else {
            x = 660;
        }
    }

    // draw the color, size and shape of the HumanPaddle
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, (int) y, 20, 80);
    }

    //define the movement of HumanPaddle
    public void move() {
        if (upAccel) {
            yVel -= 2;
        } else if (downAccel) {
            yVel += 2;
        } else if (!upAccel && !downAccel) {
            yVel *= GRAVITY;
        }

        if (yVel >= 5) {
            yVel = 5;
        } else if (yVel <= -5) {
            yVel = -5;
        }
        y += yVel;

        if (y < 0) {
            y = 0;
        }
        if (y > 420) {
            y = 420;
        }
    }

    //create mutator for the UpAccel and DownAccel boolean that allows the modification in different tennis classes
    public void setUpAccel(boolean input) {
        upAccel = input;
    }

    public void setDownAccel(boolean input) {
        downAccel = input;
    }

    // get the value for y-axis
    public int getY() {
        return (int) y;
    }
}