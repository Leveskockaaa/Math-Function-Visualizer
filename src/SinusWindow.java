import javax.swing.*;

public class SinusWindow extends PopUpWindow {
    private JTextField multiplierField;

    protected SinusWindow(Frame frame, String functionType) {
        super(frame, functionType);
    }

    @Override
    protected void saveParameters() {

    }
}