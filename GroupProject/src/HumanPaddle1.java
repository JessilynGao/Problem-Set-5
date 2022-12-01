/**********************************************************************
 * @file HumanPaddle1.java
 * @brief The HumanPaddle1 class defines the movement of the second human
 *        paddle that responds to the key events
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/
import java.awt.*;

public class HumanPaddle1 extends HumanPaddle implements Paddle {

    //create the constructor that receives the int player value
    public HumanPaddle1(int player) {
        super(player);
    }

    // draw the color, size and shape of the HumanPaddle
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, (int) y, 20, 80);
    }

}