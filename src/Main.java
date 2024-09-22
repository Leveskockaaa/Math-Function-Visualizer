import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        int distanceX = 30;
        int distanceY = 30;
        int heightX = 10;
        int widthY = 10;

        JPanel coordinateSystem = new CoordinateSystem(
                distanceX,
                distanceY,
                heightX,
                widthY
        );
        JPanel function = new Function(3,10,distanceX,distanceY);

        coordinateSystem.setBackground(new Color(0,0,0,0));
        function.setBackground(new Color(0,0,0,0));

        coordinateSystem.setPreferredSize(new Dimension(1920, 1080));
        function.setPreferredSize(new Dimension(1920, 1080));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1920, 1080));

        function.setBounds(0, 0, 1920, 1080);
        coordinateSystem.setBounds(0, 0, 1920, 1080);

        layeredPane.add(function, "Function");
        layeredPane.add(coordinateSystem, "CoordinateSystem");

        frame.add(layeredPane);
        frame.setVisible(true);
    }
}