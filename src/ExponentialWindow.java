import javax.swing.*;

public class ExponentialWindow extends PopUpWindow {
    private JTextField baseField;
    private JTextField differenceXField;
    private JTextField differenceYField;

    protected ExponentialWindow(Frame frame, String functionType) {
        super(frame, functionType);
    }

    @Override
    protected void saveParameters() {

    }
}
