import javax.swing.*;
import java.awt.*;

public class PowerWindow extends PopupWindow {
    private JTextField differenceXField;
    private JTextField differenceYField;
    private JTextField powerField;

    protected PowerWindow(Frame frame) {
        super(frame, "Power");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel functionLabel = new JLabel("f(x) = ( X +");
        differenceXField = new JTextField(2);
        JLabel exponentialLabel = new JLabel(") ^");
        powerField = new JTextField(2);
        JLabel plusLabel = new JLabel("+");
        differenceYField = new JTextField(2);

        functionLabel.setFont(font);
        differenceXField.setFont(font);
        exponentialLabel.setFont(font);
        powerField.setFont(font);
        plusLabel.setFont(font);
        differenceYField.setFont(font);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(functionLabel)
                        .addComponent(differenceXField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(exponentialLabel)
                        .addComponent(powerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(plusLabel)
                        .addComponent(differenceYField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(functionLabel)
                        .addComponent(differenceXField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(exponentialLabel)
                        .addComponent(powerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(plusLabel)
                        .addComponent(differenceYField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        JPanel container = new JPanel(new GridBagLayout());
        container.add(panel);
        add(container, BorderLayout.NORTH);
    }

    @Override
    protected void saveParameters() {
        float power = Float.parseFloat(powerField.getText());
        float differenceX = Float.parseFloat(differenceXField.getText());
        float differenceY = Float.parseFloat(differenceYField.getText());

        Color randomColor = this.getColor();
        frame.addFunction(new PowerFunction(frame.width, frame.height, power, differenceX, differenceY, frame.distanceX, frame.distanceY, randomColor));
        dispose();
    }
}
