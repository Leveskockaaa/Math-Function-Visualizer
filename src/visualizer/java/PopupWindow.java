import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class PopupWindow extends JDialog {
    Frame frame;
    String functionType;
    Font font = new Font("Monospaced", Font.BOLD, 20);
    Random random = new Random();

    protected PopupWindow(Frame frame, String functionType) {
        super(frame, "Add " + functionType);
        this.frame = frame;
        this.functionType = functionType;

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        this.add(new ButtonPanel(this), BorderLayout.SOUTH);
    }

    // Each child must implement this function, which add the correct function to the frame with the correct parameters
    protected abstract void saveParameters();

    // Random color picker
    public Color getColor() {
        Color[] colors = {Color.RED, Color.ORANGE, Color.BLUE, Color.GREEN};
        int index = random.nextInt(colors.length);
        return colors[index];
    }
}
