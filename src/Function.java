import javax.swing.*;
import java.awt.*;

public abstract class Function extends JPanel {
    int width;
    int height;
    int distanceX;
    int distanceY;
    Color color;

    public Function(int width, int height, int distanceX, int distanceY, Color color) {
        this.width = width;
        this.height = height;
        this.distanceX = distanceX;
        this.distanceY = distanceY;
        this.color = color;
    }

    public void setScale(int delta) {
        this.distanceX += delta;
        this.distanceY += delta;
        if (distanceX < 10) distanceX = 10;
        if (distanceY < 10) distanceY = 10;
        if (distanceX > 700) distanceX = 700;
        if (distanceY > 700) distanceY = 700;
    }
}