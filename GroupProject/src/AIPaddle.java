/**********************************************************************
 * @file AIPaddle.java
 * @brief The AIPaddle class defines the movement of an AI paddle that
 *        interacts with one player
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/

import java.awt.*;

    public class AIPaddle implements Paddle{

        // create variables
        double y,yVel;
        boolean upAccel, downAccel;
        int player,x;
        final double GRAVITY = 0.94;
        Ball b1;
        int AIscore = 0;


        // create a constructor that receive two variables
        public AIPaddle (int player, Ball b){
            upAccel = false;
            downAccel = false;
            b1 = b;

            // set the location of ball
            y = 210; yVel =0;
            if (player == 1){
                x = 20;
            }
            else {
                x = 660;
            }
        }


        // draw the color, size and shape of the AIPaddle
        public void draw (Graphics g){
            g.setColor(Color.red);
            g.fillRect(x,(int)y,20,80);
        }

        //allow the movement of AIPaddle corresponds to the ball
        public void move(){
            y = b1.getY() - 40;
            if (y<0){
                y = 0;
            }
            if (y>420){
                y = 420;
            }
        }

        // get the value for y-axis
        public int getY(){
            return (int)y;
        }
    }

