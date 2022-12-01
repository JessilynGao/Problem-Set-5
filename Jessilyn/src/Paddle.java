/**********************************************************************
 * @file Paddle.java
 * @brief The paddle includes three methods that will be used in the HumanPaddle and the AIPaddle class
 * @author Jessilyn Gao
 * @date: 11/20/2022
 * @acknowledgement: CS center, Dr. Pauca, and the Youtube video "How to Program Pong in Java" by
 *                   Korhn-Education
 ***********************************************************************/
import java.awt.Graphics;

public interface Paddle {
    // interface for Paddle that contains three different methods
    // which will be inherited by all paddle related classes
    public void draw(Graphics g);
    public void move();
    public int getY();
}

