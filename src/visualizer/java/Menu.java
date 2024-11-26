import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Menu extends JMenu implements ActionListener {
    Frame frame;

    // Adds the menu bar and its items
    public Menu(Frame frame, String title, String[] menuPoints, String[] menuIcons) {
        super(title);
        setFont(new CostumFont());
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        this.frame = frame;

        for (int iter = 0; iter < menuPoints.length; iter++) {
            JMenuItem menuItem = new JMenuItem(menuPoints[iter]);
            menuItem.setIconTextGap(20);
            menuItem.setIcon(new ImageIcon(menuIcons[iter]));
            menuItem.setFont(new CostumFont());
            menuItem.addActionListener(this);
            add(menuItem);
        }
    }

    // Implements the functionality of the buttons on the menu bar
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Save":
                frame.saveFunctions();
                break;
            case "Load":
                frame.loadFunctions();
                break;
            case "Exit":
                System.out.println("Closing program...");
                System.exit(0);
                break;
            case "About":
                System.out.println("About");
                System.out.println("Made by Barnabás Morvai in 2024/1 semester on BME");
                break;
            case "Documentation":
                Desktop desktop = Desktop.getDesktop();
                try {
                    File file = new File(System.getProperty("user.dir"), "documentation/prog3_nhf_dokumentacio.pdf");

                    desktop.open(file);
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
                break;
            default:
                System.out.println("Unknown action: " + actionEvent.getActionCommand());
        }
    }
}
