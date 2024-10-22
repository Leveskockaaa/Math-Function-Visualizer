import java.awt.*;

//( X + DIFFERENCE_X ) ^ POWER + DIFFERENCE_Y

public class PowerFunction extends Function {
    float power;
    float differenceX;
    float differenceY;

    public PowerFunction(int width, int height, float power, float diffX, float diffY, int distanceX, int distanceY, Color color) {
        super(width, height, distanceX, distanceY, color);
        this.power = power;
        this.differenceX = diffX;
        this.differenceY = diffY;
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
            float actualX = calculateXCoordinate(i);
            float actualY = calculateYCoordinate(i);
            polygon.addPoint((int)actualX, (int)actualY);
        }
        graphics2D.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }

    @Override
    protected float calculateXCoordinate(int position) {
        return (float) width/2 + position - differenceX*distanceX;
    }

    @Override
    protected float calculateYCoordinate(int position) {
        float base = (float) position/distanceX;
        float powerUp = (float) Math.pow(base, power);
        return (float) height/2 - powerUp*distanceY - differenceY*distanceY;
    }
}