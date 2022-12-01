/**********************************************************************
 * @file Paddle.java
 * @brief The paddle includes three methods that will be used in the HumanPaddle, HumanPaddle1,
 *        and the AIPaddle class
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/

import java.awt.Graphics;
// interface for Paddle that contains three different methods
// which will be inherited by all paddle related classes
public interface Paddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
}