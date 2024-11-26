import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionListener implements ActionListener {
    Frame frame;

    public FunctionListener(Frame frame) {
        this.frame = frame;
    }

    // Implements the listener of the buttons that add functions
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Add Linear Function": new LinearWindow(frame); break;
            case "Add Power Function": new PowerWindow(frame); break;
            case "Add Exponential Function": new ExponentialWindow(frame); break;
            case "Add Sinus Function": new SinusWindow(frame); break;
            case "Add Cosine Function": new CosineWindow(frame); break;
            default: break;
        }
    }
}
