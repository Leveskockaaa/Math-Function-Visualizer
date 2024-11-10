import javax.swing.*;
import java.awt.*;

public abstract class Function extends JPanel {
    protected int width;
    protected int height;
    protected int distanceX;
    protected int distanceY;
    protected Color color;

    protected Function(int width, int height, int distanceX, int distanceY, Color color) {
        this.width = width;
        this.height = height;
        this.distanceX = distanceX;
        this.distanceY = distanceY;
        this.color = color;
        this.setBackground(Color.WHITE);
    }

    public abstract String getName();

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(color);
        float thickness = 3f;
        graphics2D.setStroke(new BasicStroke(thickness));

        Polygon polygon = new Polygon();
        for (int i = -width/2; i <= width/2; i++) {
            float actualX = calculateXCoordinate(i);
            float actualY = calculateYCoordinate(i);
            polygon.addPoint((int) actualX, (int) actualY);
        }
        graphics2D.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }

    protected abstract float calculateXCoordinate(int position);
    protected abstract float calculateYCoordinate(int position);

    public void setScale(int delta) {
        this.distanceX += delta;
        this.distanceY += delta;
        if (distanceX < 20) distanceX = 20;
        if (distanceY < 20) distanceY = 20;
        if (distanceX > 700) distanceX = 700;
        if (distanceY > 700) distanceY = 700;
    }
}