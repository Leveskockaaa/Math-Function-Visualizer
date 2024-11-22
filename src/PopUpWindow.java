import javax.swing.*;
import java.awt.*;

public abstract class PopUpWindow extends JDialog {
    Frame frame;
    String functionType;

    protected PopUpWindow(Frame frame, String functionType) {
        super(frame, "Add " + functionType);
        this.frame = frame;
        this.functionType = functionType;

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        this.add(new ButtonPanel(this), BorderLayout.SOUTH);
    }

    protected abstract void saveParameters();
}
