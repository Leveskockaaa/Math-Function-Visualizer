import javax.swing.*;
import java.awt.*;

public class LinearWindow extends PopupWindow {
    private JTextField degreeField;
    private JTextField differenceYField;

    public LinearWindow(Frame frame) {
        super(frame, "Linear");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel functionLabel = new JLabel("f(x) = ");
        degreeField = new JTextField(2);
        JLabel multiLabel = new JLabel("* X +");
        differenceYField = new JTextField(2);

        functionLabel.setFont(font);
        degreeField.setFont(font);
        multiLabel.setFont(font);
        differenceYField.setFont(font);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(functionLabel)
                        .addComponent(degreeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(multiLabel)
                        .addComponent(differenceYField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(functionLabel)
                        .addComponent(degreeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(multiLabel)
                        .addComponent(differenceYField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        JPanel container = new JPanel(new GridBagLayout());
        container.add(panel);
        add(container, BorderLayout.NORTH);
    }

    // Gets the function parameters than adds to the frame
    @Override
    protected void saveParameters() {
        float degree = Float.parseFloat(degreeField.getText());
        float differenceY = Float.parseFloat(differenceYField.getText());

        Color randomColor = this.getColor();
        frame.addFunction(new LinearFunction(frame.width, frame.height, degree, differenceY, frame.distanceX, frame.distanceY, randomColor));
        dispose();
    }
}
