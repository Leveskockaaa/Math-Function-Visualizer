import javax.swing.*;
import java.awt.*;

public class DrawablePanel extends JPanel {
    private final Function function;

    public DrawablePanel(Function function) {
        this.function = function;

        this.function.calculatePolygon();
        this.setBackground(new Color(0,0,0,0));
        this.setPreferredSize(new Dimension(function.width, function.height));
        this.setBounds(0, 0, function.width, function.height);
        this.setFocusTraversalPolicy(null);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(function.color);
        float thickness = 3f;
        graphics2D.setStroke(new BasicStroke(thickness));
        graphics2D.drawPolyline(function.polygon.xpoints, function.polygon.ypoints, function.polygon.npoints);
    }
}
