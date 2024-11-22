import javax.swing.*;
import java.awt.*;

public class LinearWindow extends PopUpWindow {
    private JTextField degreeField;
    private JTextField differenceYField;

    public LinearWindow(Frame frame, String functionType) {
        super(frame, functionType);
        degreeField = new JTextField(10);
        differenceYField = new JTextField(10);

        //add(degreeField);
        //add(differenceYField);
    }

    @Override
    protected void saveParameters() {
        int degree = Integer.getInteger(degreeField.getText());
        int differenceY = Integer.getInteger(differenceYField.getText());

        frame.addFunction(new LinearFunction(frame.width, frame.height, degree, differenceY, frame.distanceX, frame.distanceY, Color.RED));
    }
}
