import javax.swing.*;
import java.awt.*;

public abstract class InputPanel extends JPanel {
    Frame frame;

    public InputPanel(Frame frame) {
        this.frame = frame;

        this.setMaximumSize(new Dimension(frame.getWidth(), 200));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setLayout(new BorderLayout());
    }
}
