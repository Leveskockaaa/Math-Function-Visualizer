import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SideMenu extends JPanel {
    Frame frame;
    int menuWidth;
    int menuHeight;
    int buttonWidth;

    JPanel buttonPanel = new JPanel();
    JPanel functionPanel = new JPanel();

    Map<Button, Function> buttonsOfFunctions = new HashMap<>();

    public SideMenu(Frame frame) {
        this.frame = frame;
        this.menuWidth = (int)(frame.getWidth()*0.2f);
        this.menuHeight = frame.getHeight();
        this.buttonWidth = (int)(frame.getWidth()*0.19f);

        this.setPreferredSize(new Dimension(menuWidth, menuHeight));
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        buttonPanel.setBackground(Color.WHITE);

        functionPanel.setLayout(new BoxLayout(functionPanel, BoxLayout.Y_AXIS));
        functionPanel.setBackground(Color.WHITE);
        this.initializeMenu();

        this.add(buttonPanel);
        this.add(functionPanel);
    }

    private void initializeMenu() {
        String[] buttons = new String[]{
                "Add Linear Function",
                "Add Power Function",
                "Add Exponential Function",
                "Add Sinus Function",
                "Add Cosine Function"
        };

        for (String title : buttons) {
            Button button = new Button(title, buttonWidth, Color.BLACK);
            button.addActionListener(new FunctionListener(frame));

            buttonPanel.add(Box.createVerticalStrut(5));
            buttonPanel.add(button);
            buttonPanel.add(Box.createVerticalStrut(5));
        }
    }

    public void updateMenu() {
        functionPanel.removeAll();

        for (Function function : frame.functions) {
            Button button = new Button(function.getName(), buttonWidth, function.color);
            button.addActionListener(new ButtonListener(frame, buttonsOfFunctions));
            buttonsOfFunctions.put(button, function);

            functionPanel.add(Box.createVerticalStrut(5));
            functionPanel.add(button);
            functionPanel.add(Box.createVerticalStrut(5));
        }

        revalidate();
        repaint();
    }
}
