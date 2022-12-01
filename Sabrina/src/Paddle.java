/**********************************************************************
 * @file Paddle.java
 * @brief This is the paddle interface
 * @author Sabrina Guan
 * @date: 11/20/2022
 ***********************************************************************/
import java.awt.*;

public interface Paddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
}
