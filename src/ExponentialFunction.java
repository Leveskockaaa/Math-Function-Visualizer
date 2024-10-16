import java.awt.*;

public class ExponentialFunction extends Function {
    float base;
    float differenceX;
    float differenceY;

    public ExponentialFunction(int width, int height, float base, int distanceX, int distanceY, float differenceX, float differenceY, Color color) {
        super(width, height, distanceX, distanceY, color);
        this.base = base;
        this.differenceX = differenceX;
        this.differenceY = differenceY;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(color);
        float thickness = 3f;
        graphics2D.setStroke(new BasicStroke(thickness));

        Polygon polygon = new Polygon();
        for (int i = -width/2; i < width/2; i++) {
            float powerUp = (float) Math.pow(base, (float)i/distanceX);
            float actualX = (float) width / 2 + i - differenceX * distanceX;
            float actualY = (float) height / 2 - powerUp * distanceY - differenceY * distanceY;
            polygon.addPoint((int) actualX, (int) actualY);
        }
        graphics2D.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }
}