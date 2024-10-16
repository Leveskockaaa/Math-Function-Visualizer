import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class CoordinateSystem extends JPanel {
    int distanceX;
    int distanceY;
    int heightX;
    int widthY;

    public CoordinateSystem(int width, int height, int distanceX, int distanceY, int heightX, int widthY) {
        this.distanceX = distanceX;
        this.distanceY = distanceY;
        this.heightX = heightX;
        this.widthY = widthY;

        setBackground(new Color(0,0,0,0));
        setPreferredSize(new Dimension(width,height));
        setBounds(0, 0, width, height);
    }

    public void setScale(int delta) {
        this.distanceX += delta;
        this.distanceY += delta;
        if (distanceX < 20) distanceX = 20;
        if (distanceY < 20) distanceY = 20;
        if (distanceX > 700) distanceX = 700;
        if (distanceY > 700) distanceY = 700;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        float thickness = 2f;
        graphics2D.setStroke(new BasicStroke(thickness));

        graphics.setColor(Color.BLUE);

        graphics.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        graphics.drawLine(getWidth()/2, getHeight(), getWidth()/2, 0);

        graphics2D.draw(new Arc2D.Float());

        int startX = (getWidth()/2)%distanceX;
        for (int i = startX; i < getWidth(); i += distanceX)
            graphics.drawLine(i, getHeight()/2 - heightX/2, i, getHeight()/2 + heightX/2);

        int startY = (getHeight()/2)%distanceY;
        for (int i = startY; i < getHeight(); i += distanceY)
            graphics.drawLine(getWidth()/2 - widthY/2, i, getWidth()/2 + widthY/2, i);
    }
}
