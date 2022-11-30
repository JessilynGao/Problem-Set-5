/**********************************************************************
 * @file Text.java
 * @brief The Text class helps format texts shown on the screen.
 * @author Sabrina Guan, Jessilyn Gao, Daniel Ruan, Dawn Zhong
 * @date: 11/30/2022
 ***********************************************************************/
import java.awt.*;

public class Text {
    public String text;
    public Font font;
    public double x,y;

    public Text(String text, Font font, double x, double y) {
        this.font = font;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public Text(int text, Font font, double x, double y) {
        this.font = font;
        this.text = "" + text;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setFont(font);
        g2.drawString(text, (float)x, (float)y);
    }
}
