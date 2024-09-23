import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        int distanceX = 100;
        int distanceY = 100;
        int heightX = 10;
        int widthY = 10;

        JPanel coordinateSystem = new CoordinateSystem(
                distanceX,
                distanceY,
                heightX,
                widthY
        );
        JPanel function = new Function(3,10,distanceX,distanceY);
        JPanel powerFunction = new PowerFunction(4,distanceX,distanceY);

        coordinateSystem.setBackground(new Color(0,0,0,0));
        function.setBackground(new Color(0,0,0,0));
        powerFunction.setBackground(new Color(0,0,0,0));

        coordinateSystem.setPreferredSize(new Dimension(1920, 1080));
        function.setPreferredSize(new Dimension(1920, 1080));
        powerFunction.setPreferredSize(new Dimension(1920, 1080));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1920, 1080));

        function.setBounds(0, 0, 1920, 1080);
        coordinateSystem.setBounds(0, 0, 1920, 1080);
        powerFunction.setBounds(0, 0, 1920, 1080);

        layeredPane.add(function, "Function");
        layeredPane.add(coordinateSystem, "CoordinateSystem");
        layeredPane.add(powerFunction, "PowerFunction");

        frame.add(layeredPane);
        frame.setVisible(true);
    }
}