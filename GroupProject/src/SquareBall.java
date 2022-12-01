/**********************************************************************
 * @file SquareBall.java
 * @brief The SquareBall class inherits Ball methods, which define the movement of a square ball
 *        that collide with the paddles
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 * @acknowledgement: CS center, Dr. Pauca, and the Youtube video "How to Program Pong in Java" by
 *                    Korhn-Education
 ***********************************************************************/

import java.awt.Color;
import java.awt.Graphics;

public class SquareBall extends Ball{

    //Inherits from Ball class
    //draw method reset the size of the ball
   public void draw(Graphics g) {
        g.setColor(Color.white);
       g.fillRect((int) x - 10, (int) y - 10, 20, 20);
    }


 }

