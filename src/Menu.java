import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenu implements ActionListener {
    public Menu(String title, String[] menuPoints, String[] menuIcons) {
        super(title);
        setFont(new CostumFont());
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

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
                System.out.println("Saving file...");
                break;
            case "Load":
                System.out.println("Loading file...");
                break;
            case "Exit":
                System.out.println("Closing program...");
                System.exit(0);
                break;
            case "Undo":
                System.out.println("Undo");
                break;
            case "Redo":
                System.out.println("Redo");
                break;
            case "About":
                System.out.println("About");
                break;
            case "Documentation":
                System.out.println("Documentation");
                break;
            default:
                System.out.println("Unknown action: " + actionEvent.getActionCommand());
        }
    }
}
