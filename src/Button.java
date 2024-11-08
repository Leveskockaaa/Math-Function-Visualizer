import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    String text;
    Color color;

    public Button(String text, int width, Color color) {
        this.text = text;
        this.color = color;

        this.setText(text);
        this.setForeground(color);
        this.setMaximumSize(new Dimension(width, 50));
        this.setMargin(new Insets(5, 10, 5, 10));
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setFont(new CostumFont());
    }
}
