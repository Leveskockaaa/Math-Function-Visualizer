import javax.swing.*;

public class PowerWindow extends PopUpWindow {
    private JTextField differenceXField;
    private JTextField differenceYField;
    private JTextField powerField;

    protected PowerWindow(Frame frame, String functionType) {
        super(frame, functionType);
    }

    @Override
    protected void saveParameters() {

    }
}
