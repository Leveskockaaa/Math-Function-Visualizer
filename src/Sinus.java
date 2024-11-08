import java.awt.*;

// MULTIPLIER * SIN ( X )

public class Sinus extends Function {
    float multiplier;

    public Sinus(int width, int height, float multiplier, int distanceX, int distanceY, Color color) {
        super(width, height, distanceX, distanceY, color);
        this.multiplier = multiplier;
    }

    @Override
    public String getName() {
        return "Sinus Function";
    }

    @Override
    protected float calculateXCoordinate(int position) {
        return (float) width/2 + position;
    }

    @Override
    protected float calculateYCoordinate(int position) {
        float sin = (float) position/distanceX;
        float functionHeight = (float) Math.sin(sin)*distanceY * multiplier;
        return (float) height/2 - functionHeight;
    }
}