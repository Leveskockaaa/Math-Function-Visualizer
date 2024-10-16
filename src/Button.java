import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    String text;

    public Button(String text) {
        this.text = text;
        this.setText(text);

        this.setPreferredSize(new Dimension(300, 40));
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setFont(new CostumFont());
    }
}
