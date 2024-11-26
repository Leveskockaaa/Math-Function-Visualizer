import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class Frame extends JFrame implements MouseWheelListener {
    int width;
    int height;
    int distanceX;
    int distanceY;
    int heightX;
    int widthY;

    HashMap<Function, DrawablePanel> functions = new HashMap<>();
    CoordinateSystem coordinateSystem;
    LayeredPane layeredPane = new LayeredPane();
    MenuBar menuBar;
    SideMenu sideMenu;

    public Frame(int width, int height, int distanceX, int distanceY, int heightX, int widthY) {
        super("Math Function Visualizer");
        this.width = width;
        this.height = height;
        this.distanceX = distanceX;
        this.distanceY = distanceY;
        this.heightX = heightX;
        this.widthY = widthY;

        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addMouseWheelListener(this);

        sideMenu = new SideMenu(this);
        coordinateSystem = new CoordinateSystem(width, height, distanceX, distanceY, heightX, widthY);
        layeredPane.add(coordinateSystem);
        this.add(layeredPane, BorderLayout.CENTER);
        this.add(sideMenu, BorderLayout.EAST);

        List<String> menuTitles = Arrays.asList("File", "Help");
        List<String[]> subMenuTitles = Arrays.asList(
                new String[]{"Save", "Load", "Exit"},
                new String[]{"About", "Documentation"});
        List<String[]> subMenuIcons = Arrays.asList(
                new String[]{"save.png", "load.png", "exit.png"},
                new String[]{"about.png", "documentation.png"});
        menuBar = new MenuBar(this, menuTitles, subMenuTitles, subMenuIcons);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    // Creates a new DrawablePanel with the input function, then saves both of them as a pair in a HashMap
    public void addFunction(Function function) {
        DrawablePanel functionPanel = new DrawablePanel(function);
        functionPanel.setVisible(true);

        functions.put(function, functionPanel);
        sideMenu.updateMenu();

        layeredPane.add(functionPanel);
        this.add(layeredPane, BorderLayout.CENTER);
    }

    // Deletes the input function from the screen and from the HashMap then updates the side menu
    public void removeFunction(Function function) {
        layeredPane.remove(functions.get(function));
        functions.remove(function);
        sideMenu.updateMenu();

        revalidate();
        repaint();
    }

    // Set the scale of the functions and the coordinate system
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
        for (Map.Entry<Function, DrawablePanel> entry : functions.entrySet()) {
            Function function = entry.getKey();
            DrawablePanel functionPanel = entry.getValue();

            function.setScale(delta);
            function.calculatePolygon();
            functionPanel.repaint();
        }

        revalidate();
        repaint();
    }

    // Saves the functions as a List in a txt file
    public void saveFunctions() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save file");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text files (*.txt)", "txt"));

        File defaultDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(defaultDirectory);

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().endsWith(".txt")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
            }
            String filename = fileToSave.getAbsolutePath();

            ArrayList<Function> outputFunctions = new ArrayList<>(functions.keySet());

            try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

                objectOutputStream.writeObject(outputFunctions);
                System.out.println("Succesful: " + filename);
            } catch (IOException exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Loads the functions from a txt file then add those to the screen, updates the side menu
    public void loadFunctions() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load file");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text files (*.txt)", "txt"));

        File defaultDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(defaultDirectory);

        int userSelection = fileChooser.showOpenDialog(null);

        ArrayList<Function> inputFunctions = new ArrayList<>();
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            String filename = fileToLoad.getAbsolutePath();

            try (FileInputStream fileInputStream = new FileInputStream(filename);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                inputFunctions = (ArrayList<Function>) objectInputStream.readObject();
                System.out.println("Succesful: " + filename);

            } catch (IOException | ClassNotFoundException exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        Iterator<Map.Entry<Function, DrawablePanel>> iterator = functions.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Function, DrawablePanel> function = iterator.next();
            DrawablePanel functionPanel = function.getValue();

            layeredPane.remove(functionPanel);
            iterator.remove();
            revalidate();
            repaint();
        }

        functions.clear();
        for (Function function : inputFunctions) {
            addFunction(function);
        }

        coordinateSystem.setDistanceX(inputFunctions.getFirst().getDistanceX());
        coordinateSystem.setDistanceY(inputFunctions.getFirst().getDistanceY());
        this.distanceX = inputFunctions.getFirst().getDistanceX();
        this.distanceY = inputFunctions.getFirst().getDistanceY();
    }
}
