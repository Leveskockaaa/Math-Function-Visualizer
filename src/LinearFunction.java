import java.awt.*;

// DEGREE * X + DIFFERENCE_Y

public class LinearFunction extends Function {
    int degree;
    int differenceY;

    public LinearFunction(int width, int height, int degree, int diffY, int distanceX, int distanceY, Color color) {
        super(width, height, distanceX, distanceY, color);
        this.degree = degree;
        this.differenceY = diffY;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        float thickness = 3f;
        graphics2D.setStroke(new BasicStroke(thickness));
        graphics.setColor(color);

        Polygon polygon = new Polygon();
        for (int i = -width/2; i <= width/2; i++) {
            float actualX = (float) width/2 + i;
            float actualY = (float) height/2 - i;
            polygon.addPoint((int) actualX, (int) actualY);
        }

        int upFrameX = height/2/degree + width/2 - (differenceY * distanceY)/degree;
        int upFrameY = 0;
        int downFrameX = width/2 - height/2/degree - (differenceY * distanceY)/degree;
        int downFrameY = height;

        graphics.drawLine(upFrameX, upFrameY, downFrameX, downFrameY);
    }
}