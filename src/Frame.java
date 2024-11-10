import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Frame extends JFrame implements MouseWheelListener {
    int width;
    int height;
    int distanceX;
    int distanceY;
    int heightX;
    int widthY;

    ArrayList<Function> functions = new ArrayList<>();
    CoordinateSystem coordinateSystem;
    LayeredPane layeredPane = new LayeredPane();
    MenuBar menuBar;
    SideMenu sideMenu = new SideMenu(this);

    public Frame(int width, int height, int distanceX, int distanceY, int heightX, int widthY) {
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setLayout(new BorderLayout(10, 10));
        this.addMouseWheelListener(this);

        this.width = width;
        this.height = height;
        this.distanceX = distanceX;
        this.distanceY = distanceY;
        this.heightX = heightX;
        this.widthY = widthY;

        sideMenu = new SideMenu(this);
        coordinateSystem = new CoordinateSystem(width, height, distanceX, distanceY, heightX, widthY);
        layeredPane.add(coordinateSystem);
        this.add(layeredPane, BorderLayout.CENTER);
        this.add(sideMenu, BorderLayout.EAST);

        List<String> menuTitles = Arrays.asList("File", "Edit", "Help");
        List<String[]> subMenuTitles = Arrays.asList(
                new String[]{"Save", "Load", "Exit"},
                new String[]{"Undo", "Redo"},
                new String[]{"About", "Documentation"});
        List<String[]> subMenuIcons = Arrays.asList(
                new String[]{"save.png", "load.png", "exit.png"},
                new String[]{"undo.png", "redo.png"},
                new String[]{"about.png", "documentation.png"});
        menuBar = new MenuBar(menuTitles, subMenuTitles, subMenuIcons);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    public void addFunction(Function function) {
        function.setBackground(new Color(0,0,0,0));
        function.setPreferredSize(new Dimension(width, height));
        function.setBounds(0, 0, width, height);

        functions.add(function);
        sideMenu.updateMenu();

        layeredPane.add(function);
        this.add(layeredPane, BorderLayout.CENTER);
    }

    public void removeFunction(Function function) {
        functions.remove(function);
        layeredPane.remove(function);
        sideMenu.updateMenu();

        revalidate();
        repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event) {
        int delta = event.getWheelRotation() < 0 ? 10 : -10;

        distanceX += delta;
        distanceY += delta;
        if (distanceX < 20) distanceX = 20;
        if (distanceY < 20) distanceY = 20;
        if (distanceX > 700) distanceX = 700;
        if (distanceY > 700) distanceY = 700;

        coordinateSystem.setScale(delta);
        for (Function function : functions) {
            function.setScale(delta);
        }
        revalidate();
        repaint();
    }
}
