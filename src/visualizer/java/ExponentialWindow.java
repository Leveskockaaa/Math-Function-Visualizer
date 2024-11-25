import javax.swing.*;
import java.awt.*;

public class ExponentialWindow extends PopupWindow {
    private JTextField baseField;
    private JTextField differenceXField;
    private JTextField differenceYField;

    protected ExponentialWindow(Frame frame) {
        super(frame, "Exponential");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel functionLabel = new JLabel("f(x) = (");
        baseField = new JTextField(2);
        JLabel plusLabel = new JLabel("+");
        differenceXField = new JTextField(2);
        JLabel powerLabel = new JLabel(") ^ x +");
        differenceYField = new JTextField(2);

        functionLabel.setFont(font);
        baseField.setFont(font);
        plusLabel.setFont(font);
        differenceXField.setFont(font);
        powerLabel.setFont(font);
        differenceYField.setFont(font);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(functionLabel)
                        .addComponent(baseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(plusLabel)
                        .addComponent(differenceXField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(powerLabel)
                        .addComponent(differenceYField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(functionLabel)
                        .addComponent(baseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(plusLabel)
                        .addComponent(differenceXField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(powerLabel)
                        .addComponent(differenceYField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        JPanel container = new JPanel(new GridBagLayout());
        container.add(panel);
        add(container, BorderLayout.NORTH);
    }

    @Override
    protected void saveParameters() {
        float base = Float.parseFloat(baseField.getText());
        float differenceX = Float.parseFloat(differenceXField.getText());
        float differenceY = Float.parseFloat(differenceYField.getText());

        Color randomColor = this.getColor();
        frame.addFunction(new ExponentialFunction(frame.width, frame.height, base, frame.distanceX, frame.distanceY, differenceX, differenceY, randomColor));
        dispose();
    }
}
