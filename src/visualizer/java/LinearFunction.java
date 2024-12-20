import java.awt.*;

// DEGREE * X + DIFFERENCE_Y

public class LinearFunction extends Function {
    float degree;
    float differenceY;

    public LinearFunction(int width, int height, float degree, float diffY, int distanceX, int distanceY, Color color) {
        super(width, height, distanceX, distanceY, color);
        this.degree = degree;
        this.differenceY = diffY;
    }

    @Override
    public String getName() {
        return "Linear Function";
    }

    @Override
    protected float calculateXCoordinate(int position) {
        return (float) width / 2 + position;
    }

    @Override
    protected float calculateYCoordinate(int position) {
        return (float) height / 2 - position*degree - differenceY*distanceY;
    }
}