import javax.swing.*;
import java.awt.*;

public class SinusWindow extends PopupWindow {
    private JTextField multiplierField;

    protected SinusWindow(Frame frame) {
        super(frame, "Sinus");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel functionLabel = new JLabel("f(x) = ");
        multiplierField = new JTextField(2);
        JLabel cosLabel = new JLabel("* sin(x)");

        functionLabel.setFont(font);
        multiplierField.setFont(font);
        cosLabel.setFont(font);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(functionLabel)
                        .addComponent(multiplierField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cosLabel)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(functionLabel)
                        .addComponent(multiplierField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cosLabel)
        );

        JPanel container = new JPanel(new GridBagLayout());
        container.add(panel);
        add(container, BorderLayout.NORTH);
    }

    @Override
    protected void saveParameters() {
        float multiplier = Float.parseFloat(multiplierField.getText());

        Color randomColor = this.getColor();
        frame.addFunction(new Sinus(frame.width, frame.height, multiplier, frame.distanceX, frame.distanceY, randomColor));
        dispose();
    }
}