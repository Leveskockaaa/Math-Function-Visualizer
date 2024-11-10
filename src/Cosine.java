import java.awt.*;

// MULTIPLIER * COS( X )

public class Cosine extends Function {
    float multiplier;

    public Cosine(int width, int height, float multiplier, int distanceX, int distanceY, Color color) {
        super(width, height, distanceX, distanceY, color);
        this.multiplier = multiplier;
    }

    @Override
    public String getName() {
        return "Cosine Function";
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

