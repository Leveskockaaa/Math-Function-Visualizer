import java.awt.*;

// ( X + DIFFERENCE_X ) ^ POWER + DIFFERENCE_Y

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
    public String getName() {
        return "Power Function";
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