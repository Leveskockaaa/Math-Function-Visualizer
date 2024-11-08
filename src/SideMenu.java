import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideMenu extends JPanel implements ActionListener {
    Frame frame;
    int menuWidth;
    int menuHeight;
    int buttonWidth;

    JPanel buttonPanel = new JPanel();
    JPanel functionPanel = new JPanel();

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
            button.addActionListener(this);
            buttonPanel.add(Box.createVerticalStrut(5));
            buttonPanel.add(button);
            buttonPanel.add(Box.createVerticalStrut(5));
        }
    }

    public void updateMenu() {
        functionPanel.removeAll();

        for (Function function : frame.functions) {
            Button button = new Button(function.getName(), buttonWidth, function.color);
            functionPanel.add(Box.createVerticalStrut(5));
            functionPanel.add(button);
            functionPanel.add(Box.createVerticalStrut(5));
        }

        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Add Linear Function")) {
            Function linearFunction = new LinearFunction(frame.width, frame.height,1,0,frame.distanceX, frame.distanceY, Color.ORANGE);
            frame.addFunction(linearFunction);
        }
        if (event.getActionCommand().equals("Add Power Function")) {
            Function powerFunction = new PowerFunction(frame.width, frame.height,2,0,0,frame.distanceX, frame.distanceY, Color.ORANGE);
            frame.addFunction(powerFunction);
        }
        if (event.getActionCommand().equals("Add Exponential Function")) {
            Function exponentialFunction = new ExponentialFunction(frame.width, frame.height,2, frame.distanceX, frame.distanceY, 0, 0, Color.ORANGE);
            frame.addFunction(exponentialFunction);
        }
        if (event.getActionCommand().equals("Add Sinus Function")) {
            Function sinusFunction = new Sinus(frame.width, frame.height,3, frame.distanceX, frame.distanceY, Color.ORANGE);
            frame.addFunction(sinusFunction);
        }
        if (event.getActionCommand().equals("Add Cosine Function")) {
            Function cosineFunction = new Cosine(frame.width, frame.height,2, frame.distanceX, frame.distanceY, Color.ORANGE);
            frame.addFunction(cosineFunction);
        }
    }
}
