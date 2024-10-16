import java.awt.*;

public class Sinus extends Function {
    float multiplier;

    public Sinus(int width, int height, float multiplier, int distanceX, int distanceY, Color color) {
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
            float sin = (float) i/distanceX;
            float function_height = (float) Math.sin(sin)*distanceY*multiplier;
            float actualY = (float) height/2 - function_height;
            polygon.addPoint((int) actualX, (int) actualY);
        }
        graphics2D.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }
}
