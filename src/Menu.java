import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Menu extends JMenu implements ActionListener {
    Frame frame;

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
                break;
            case "Documentation":
                Desktop desktop = Desktop.getDesktop();
                try {
                    File file = new File("prog3_nhf_specifikacio.pdf");
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
