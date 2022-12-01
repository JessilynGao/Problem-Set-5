/**********************************************************************
 * @file Ball.java
 * @brief The Ball class defines the movement of the round ball that
 *        collide with the paddles
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/
import java.awt.*;

public class Ball {

    // create variables
    double xVel, yVel, x, y;

    // create a construct that set the initial location of the ball and the speed and movement
    public Ball() {
        x = 350;
        y = 250;
        xVel = getRandomSpeed() * getRandomDirection();
        yVel = getRandomSpeed() * getRandomDirection();

    }

    // ball speed is set to be random
    public double getRandomSpeed() {
        return (Math.random() * 3+1);

    }

    // ball direction is set to be random
    public double getRandomDirection() {
        int rand = (int) (Math.random() * 2);
        if (rand == 1) {
            return 1;
        } else
            return -1;
    }

    // create a draw method which include the size and color of the ball
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) x - 10, (int) y - 10, 20, 20);
    }

    //check if the ball collides with paddle 1 or paddle2
    public void checkPaddleCollision(Paddle p1, Paddle p2) {
        if (x <= 50) {
            if (y >= p1.getY() && y <= p1.getY() + 80) {
                xVel = -xVel;
            }
        } else if (x >= 650) {
            if (y >= p2.getY() && y <= p2.getY() + 80) {
                xVel = -xVel;
            }
        }
    }

    // move method that defines the in direction of the ball when it hit paddles
    public void move() {
        x += xVel;
        y += yVel;

        if (y < 10) {
            yVel = -yVel;
        }
        if (y > 490) {
            yVel = -yVel;
        }
    }

    //getX and getY method return x-axis and y-axis value
    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }


}