import javax.swing.*;

public class PopUpWindow extends JDialog {
    Frame frame;
    String functionType;

    public PopUpWindow(Frame frame, String functionType) {
        super(frame, "Add " + functionType);
        this.frame = frame;
        this.functionType = functionType;

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }
}
