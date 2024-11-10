import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ButtonListener implements ActionListener {
    Frame frame;
    Map<Button, Function> buttons;

    public ButtonListener(Frame frame, Map<Button, Function> buttons) {
        this.frame = frame;
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        for (Map.Entry<Button, Function> entry : buttons.entrySet()) {
            Button button = entry.getKey();
            Function function = entry.getValue();

            if (clickedButton.equals(button)) {
                frame.removeFunction(function);
            }
        }
    }
}
