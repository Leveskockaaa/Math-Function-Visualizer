import java.awt.*;

public class Cosinus extends Function {
    float multiplier;

    public Cosinus(int width, int height, float multiplier, int distanceX, int distanceY, Color color) {
        super(width, height, distanceX, distanceY, color);
        this.multiplier = multiplier;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(color);
        float thickness = 3f;
        graphics2D.setStroke(new BasicStroke(thickness));

        Polygon polygon = new Polygon();
        for (int i = -width/2; i <= width/2; i++) {
            float actualX = (float) width/2 + i;
            float actualY = (float) height/2 - (float) Math.cos((double) i/distanceX)*distanceY*multiplier;
            polygon.addPoint((int) actualX, (int) actualY);
        }
        graphics2D.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }
}

