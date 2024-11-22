import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    PopUpWindow window;

    public ButtonPanel(PopUpWindow popUpWindow) {
        window = popUpWindow;

        this.setMaximumSize(new Dimension(window.getWidth(), 100));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(event -> window.saveParameters());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> window.dispose());

        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalGlue());

        add(buttonPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
