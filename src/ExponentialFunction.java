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
    protected float calculateXCoordinate(int position) {
        return (float) width/2 + position - differenceX * distanceX;
    }

    @Override
    protected float calculateYCoordinate(int position) {
        float powerUp = (float) Math.pow(base, (float) position/distanceX);
        return (float) height/2 - powerUp * distanceY - differenceY * distanceY;
    }
}