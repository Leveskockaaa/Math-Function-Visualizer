import java.awt.*;

public class Cosinus extends Function {
    float multiplier;

    public Cosinus(int width, int height, float multiplier, int distanceX, int distanceY, Color color) {
        super(width, height, distanceX, distanceY, color);
        this.multiplier = multiplier;
    }

    @Override
    protected float calculateXCoordinate(int position) {
        return (float) width/2 + position;
    }

    @Override
    protected float calculateYCoordinate(int position) {
        float cos = (float) position/distanceX;
        float functionY = (float) Math.cos(cos) * distanceY * multiplier;
        return (float) height/2 - functionY;
    }
}

