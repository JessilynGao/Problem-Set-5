/**********************************************************************
 * @file Paddle.java
 * @brief This is the Paddle Interface
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/
import java.awt.Graphics;
public interface Paddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
}