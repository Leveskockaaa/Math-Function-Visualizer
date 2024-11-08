import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideMenu extends JPanel implements ActionListener {
    Frame frame;

    public SideMenu(Frame frame) {
        this.frame = frame;

        this.setPreferredSize(new Dimension((int)(frame.getWidth()*0.2), frame.getHeight()));
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        String[] buttons = new String[]{
                "Add Linear Function",
                "Add Power Function",
                "Add Exponential Function",
                "Add Sinus Function",
                "Add Cosine Function"
        };

        for (String title : buttons) {
            Button button = new Button(title);
            button.addActionListener(this);
            buttonPanel.add(Box.createVerticalStrut(5));
            buttonPanel.add(button);
            buttonPanel.add(Box.createVerticalStrut(5));
        }

        this.add(buttonPanel, BorderLayout.NORTH);
    }

    private void listFunctions() {
        for (Function function : frame.functions) {
            this.add(new Button(function.getName()));
        }
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
