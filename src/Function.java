import javax.swing.*;
import java.awt.*;

public class Function extends JPanel {
    int degree;
    int diffY;
    int DistanceX;
    int DistanceY;

    public Function(int degree, int diffY,int coordinateSystemDistanceX, int coordinateSystemDistanceY) {
        this.degree = degree;
        this.diffY = diffY;
        this.DistanceX = coordinateSystemDistanceX;
        this.DistanceY = coordinateSystemDistanceY;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        float thickness = 3f;
        graphics2D.setStroke(new BasicStroke(thickness));
        graphics.setColor(Color.GREEN);

        graphics.drawLine((getHeight()/2)/degree + getWidth()/2 - (diffY*DistanceY)/degree,
                0,
                getWidth()/2 - (getHeight()/2)/degree - (diffY*DistanceY)/degree,
                getHeight()
        );
    }
}
