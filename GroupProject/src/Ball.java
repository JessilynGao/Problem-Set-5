/**********************************************************************
 * @file Ball.java
 * @brief The Ball class defines the movement of the round ball that
 * collide with the paddles
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/
import java.awt.*;

public class Ball {
    double xVel, yVel, x, y;

    public Ball () {
        x =350;
        y=250;
        xVel = getRandomDirection() * getRandomSpeed();
        yVel = getRandomDirection() * getRandomSpeed();
    }

    public double getRandomSpeed() {
        return (Math.random()*3 + 1);
    }

    public int getRandomDirection (){
        int rand = (int) (Math.random()*2);
        if (rand ==1)
            return 1;
        else
            return -1;
    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)x-10, (int) y-10, 20, 20 );
    }


    public void checkPaddleCollision(HumanPaddle p1, AIPaddle p2) {
        if (x <= 50) {
            if (y>=p1.getY() && y<= p2.getY() + 80)
                xVel = -xVel;
        }
        else if (x>=650) {
            if (y>= p2.getY() && y<= p2.getY()+80)
                xVel = -xVel;
        }
    }

    public void checkPaddleCollision2(HumanPaddle p1, HumanPaddle1 p2) {
        if (x <= 50) {
            if (y>=p1.getY() && y<= p2.getY() + 80)
                xVel = -xVel;
        }
        else if (x>=650) {
            if (y>= p2.getY() && y<= p2.getY()+80)
                xVel = -xVel;
        }
    }

    public void checkPaddleCollision3(HumanPaddle p1, HumanPaddle1 p2) {
        if (x <= 50) {
            if (y>=p1.getY() && y<= p2.getY() + 80)
                xVel = -xVel;
        }
        else if (x>=650) {
            if (y>= p2.getY() && y<= p2.getY()+80)
                xVel = -xVel;
        }
    }

    public void move(){
        x+=xVel;
        y+=yVel;

        if (y<10)
            yVel = -yVel;
        if (y>490)
            yVel = -yVel;
    }


    public int getX(){
        return (int) x;
    }

    public int getY(){
        return (int) y;
    }

}
