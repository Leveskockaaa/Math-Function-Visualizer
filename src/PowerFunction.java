import javax.swing.*;
import java.awt.*;

public class PowerFunction extends JPanel {
    float power;
    int distanceX;
    int distanceY;

    public PowerFunction(float power, int distanceX, int distanceY) {
        this.power = power;
        this.distanceX = distanceX;
        this.distanceY = distanceY;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.RED);
        float thickness = 3f;
        graphics2D.setStroke(new BasicStroke(thickness));

        Polygon polygon = new Polygon();
        for (int i = -getWidth()/2; i < getWidth()/2; i++) {
            float base = (float) i/distanceX;
            float powerUp = (float) Math.pow(base, power);
            float actualX = (float)getWidth()/2 + i;
            float actualY = (float)getHeight()/2 - powerUp*distanceY;
            polygon.addPoint((int)actualX, (int)actualY);
        }
        graphics2D.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }
}
