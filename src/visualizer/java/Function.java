import java.awt.*;
import java.io.Serializable;

public abstract class Function implements Serializable {
    public Polygon polygon = new Polygon();
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
    }

    public abstract String getName();
    public int getDistanceX() {
        return distanceX;
    }
    public int getDistanceY() {
        return distanceY;
    }

    // Calculates the polygon of the function by iterating across the width of the screen
    public void calculatePolygon() {
        polygon.reset();
        for (int iter = -width/2; iter <= width/2; iter++) {
            float actualX = calculateXCoordinate(iter);
            float actualY = calculateYCoordinate(iter);
            polygon.addPoint((int) actualX, (int) actualY);
        }
    }

    // Each child must implement these two functions, which calculate the x and y coordinates
    protected abstract float calculateXCoordinate(int position);
    protected abstract float calculateYCoordinate(int position);

    // Sets the scale of the function
    public void setScale(int delta) {
        this.distanceX += delta;
        this.distanceY += delta;
        if (distanceX < 20) distanceX = 20;
        if (distanceY < 20) distanceY = 20;
        if (distanceX > 700) distanceX = 700;
        if (distanceY > 700) distanceY = 700;
    }
}